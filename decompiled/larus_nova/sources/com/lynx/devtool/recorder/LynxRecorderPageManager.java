package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.Intent;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderPageManager {
    private static final String TAG = "LynxRecorderPageManager";
    private static LynxRecorderPageManager instance;
    private AtomicInteger count;
    private JSONObject mActivities;
    private int mActivityLaunchFlags;
    private ArrayList<LynxRecorderActionCallback> mCallbacks;
    private JSONObject mGroups;
    private boolean mIsMultiEnv;
    private ArrayList<String> mPageStack;
    private JSONObject mPages;
    private JSONObject mRouters;

    private void clear() {
        this.mIsMultiEnv = false;
        this.mPages = new JSONObject();
        this.mRouters = new JSONObject();
        this.mActivities = new JSONObject();
        this.mGroups = new JSONObject();
        this.mPageStack = new ArrayList();
    }

    public static synchronized LynxRecorderPageManager getInstance() {
        monitor-enter(LynxRecorderPageManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        LynxRecorderPageManager r100 = new LynxRecorderPageManager();     // Catch: Throwable -> L10
        instance = r100;     // Catch: Throwable -> L10
        r100.clear();     // Catch: Throwable -> L10
    L7:
        LynxRecorderPageManager r101 = instance;     // Catch: Throwable -> L10
        monitor-exit(LynxRecorderPageManager.class);
        return r101;
    }

    private int incrementAndGet() {
        return this.count.incrementAndGet();
    }

    private LynxRecorderPageManager() {
        this.count = new AtomicInteger(0);
        this.mCallbacks = new ArrayList();
    }

    public ArrayList<LynxRecorderActionCallback> getCallbacks() {
        return this.mCallbacks;
    }

    public static /* synthetic */ ArrayList access$300(LynxRecorderPageManager r100) {
        return r100.mPageStack;
    }

    private String buildPageName(String r100) {
        return r100 + "#" + String.valueOf(incrementAndGet());
    }

    private String getRawPageName(String r100) {
        return r100.split("#")[0];
    }

    private boolean isDescribeFile(String r100) {
        QueryMapUtils r101 = new QueryMapUtils();
        r101.parse(r100);
        if (r101.getString("describe_file") != null) goto L5;
    L8:
        return false;
    L5:
        if (r101.getBoolean("describe_file", false) == false) goto L8;
        return true;
    }

    private boolean isMultiPagesFile(String r100) {
        QueryMapUtils r101 = new QueryMapUtils();
        r101.parse(r100);
        if (r101.getString("multi-page") != null) goto L5;
    L8:
        return false;
    L5:
        if (r101.getBoolean("multi-page", false) == false) goto L8;
        return true;
    }

    public void registerCallback(LynxRecorderActionCallback r100) {
        this.mCallbacks.add(r100);
    }

    public void replayPageFromOpenSchema(ReadableMap r100) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        ArrayList<String> r101 = this.mPageStack;
        String r102 = (String) ListProtector.get(r101, r101.size() - 1);
        String r103 = getRawPageName(r102);
        JSONObject r104 = this.mRouters.optJSONObject(r103).optJSONObject(r100.getString("label"));
        boolean r105 = r104.optBoolean("popLast");
        String r106 = r104.optString(TeaEventTrack.ACTION_DRAMA_NEXT);
        if (r105 == false) goto L8;
        ArrayList<String> r107 = this.mPageStack;
        ListProtector.remove(r107, r107.size() - 1);
    L8:
        this.mPageStack.add(buildPageName(r106));
        replayCurrPage((LynxRecorderActivity) this.mActivities.opt(r102), r105);
    }

    public static /* synthetic */ JSONObject access$002(LynxRecorderPageManager r100, JSONObject r101) {
        r100.mPages = r101;
        return r101;
    }

    public static /* synthetic */ JSONObject access$102(LynxRecorderPageManager r100, JSONObject r101) {
        r100.mRouters = r101;
        return r101;
    }

    public static /* synthetic */ String access$200(LynxRecorderPageManager r100, String r101) {
        return r100.buildPageName(r101);
    }

    private Intent getTestBenchIntent(Context r100, String r101) {
        Intent r102 = new Intent(r100, LynxRecorderActivity.class);
        r102.addFlags(this.mActivityLaunchFlags);
        r102.putExtra(LynxRecorderEnv.getInstance().mUriKey, r101);
        return r102;
    }

    public void initLynxGroup(String r100, LynxRecorderActivity r101) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        LynxRecorderActivity r102 = (LynxRecorderActivity) this.mGroups.opt(r100);
        if (r102 == null) goto L13;
        r101.setLynxGroup(r102.getLynxGroup());
        return;
    L13:
        this.mGroups.put(r100, r101);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public void loadDescribeFile(String r100, final Context r101) {
        QueryMapUtils r102 = new QueryMapUtils();
        r102.parse(r100);
        String r103 = r102.getString("url");
        LynxEnv.inst().getTemplateProvider().loadTemplate(r103, new AnonymousClass1(this, r101));
    }

    public void onActivityDestroy(String r100, boolean r101) {
        if (this.mIsMultiEnv == true) goto L5;
        return;
    L5:
        if (r101 == true) goto L7;
        ArrayList<String> r102 = this.mPageStack;
        ListProtector.remove(r102, r102.size() - 1);
    L7:
        this.mActivities.remove(r100);
    }

    public void registerActivity(String r100, LynxRecorderActivity r101) {
        if (this.mIsMultiEnv == true) goto L10;
        return;
    L10:
        this.mActivities.put(r100, r101);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void replayCurrPage(Context r100, boolean r101) {
        ArrayList<String> r102 = this.mPageStack;
        String r103 = (String) ListProtector.get(r102, r102.size() - 1);
        String r104 = getRawPageName(r103);
        JSONObject r105 = this.mPages.optJSONObject(r104);
        if (r105 != null) goto L5;
        return;
    L5:
        Intent r106 = getTestBenchIntent(r100, r105.optString("url"));
        r106.putExtra("groupName", r105.optString("group"));
        r106.putExtra("pageName", r103);
        r100.startActivity(r106);
        if (r101 == false) goto L9;
        LynxRecorderActivity r107 = (LynxRecorderActivity) r100;
        r107.setState(true);
        r107.finish();
        return;
    }

    public void replayMultiPages(String r100, Context r101) {
        clear();
        this.mIsMultiEnv = true;
        loadDescribeFile(r100, r101);
    }

    public void replayMultiPagesInOneActivity(String r100, Context r101) {
        clear();
        this.mIsMultiEnv = true;
        Intent r102 = new Intent(r101, LynxRecorderMultiPagesActivity.class);
        r102.addFlags(this.mActivityLaunchFlags);
        r102.putExtra(LynxRecorderEnv.getInstance().mUriKey, r100);
        r101.startActivity(r102);
    }

    public void replaySignalPage(String r100, Context r101) {
        clear();
        this.mIsMultiEnv = false;
        r101.startActivity(getTestBenchIntent(r101, r100));
    }

    public void startReplay(String r100, Context r101, int r102) {
        this.mActivityLaunchFlags = r102;
        if (isDescribeFile(r100) == false) goto L6;
        replayMultiPages(r100, r101);
        return;
    L6:
        if (isMultiPagesFile(r100) == false) goto L8;
        replayMultiPagesInOneActivity(r100, r101);
        return;
    L8:
        replaySignalPage(r100, r101);
    }
}
