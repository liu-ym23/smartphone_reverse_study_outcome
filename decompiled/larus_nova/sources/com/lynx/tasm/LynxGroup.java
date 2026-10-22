package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LynxGroup {
    public static String SINGNLE_GROUP = "-1";
    private static int sNextID;
    private Map<String, Object> mConfig;
    private boolean mEnableCanvas;
    private boolean mEnableJSGroupThread;
    private boolean mEnableV8;
    private String mGroupName;
    private String mID;
    private String mJSGroupThreadName;
    private String[] mPreloadJSPaths;
    private LynxWhiteBoard mWhiteBoard;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f381661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f381662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f381663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f381664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f381665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f381666f;

        public a() {
        }

        public LynxGroup a() {
            return new LynxGroup(this);
        }
    }

    public static String generateID() {
        String r100 = String.format("%d", new Object[]{Integer.valueOf(sNextID)});
        sNextID++;
        return r100;
    }

    public boolean useProviderJsEnv() {
        return false;
    }

    public void destroy() {
        LynxWhiteBoard r100 = this.mWhiteBoard;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public String getJSGroupThreadNameOrDefault() {
        String r100 = this.mJSGroupThreadName;
        if (r100 == null) goto L8;
        if (r100.isEmpty() == true) goto L8;
        return this.mJSGroupThreadName;
    L8:
        return this.mID;
    }

    public long getWhiteBoardPtr() {
        LynxWhiteBoard r100 = this.mWhiteBoard;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f381741a;
    }

    public boolean enableCanvas() {
        return this.mEnableCanvas;
    }

    public boolean enableDynamicV8() {
        return this.mEnableV8;
    }

    public boolean enableJSGroupThread() {
        return this.mEnableJSGroupThread;
    }

    public boolean enableV8() {
        return this.mEnableV8;
    }

    public String getID() {
        return this.mID;
    }

    public String getJSGroupThreadName() {
        return this.mJSGroupThreadName;
    }

    public String[] getPreloadJSPaths() {
        return this.mPreloadJSPaths;
    }

    public LynxGroup(a r100) {
        this.mGroupName = r100.f381661a;
        String r101 = r100.f381662b;
        if (r101 != null) goto L6;
        r101 = generateID();
    L6:
        this.mID = r101;
        this.mPreloadJSPaths = r100.f381663c;
        Boolean r102 = r100.f381666f;
        if (r102 != null) goto L9;
        this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
    L10:
        this.mJSGroupThreadName = null;
        this.mEnableV8 = r100.f381665e;
        this.mConfig = null;
        this.mEnableCanvas = r100.f381664d;
        LLog.i("LynxGroup", "LynxGroup init with name " + this.mGroupName + ", id: " + this.mID + ", enableV8: " + this.mEnableV8 + ", canvas:" + this.mEnableCanvas);
        return;
    L9:
        this.mEnableJSGroupThread = r102.booleanValue();
        goto L10
    }

    public static LynxGroup Create(String r100) {
        return Create(r100, null);
    }

    public boolean getBoolConfig(String r100) {
        Map<String, Object> r101 = this.mConfig;
        if (r101 != null) goto L5;
        return false;
    L5:
        Object r102 = r101.get(r100);
        if (r102 != null) goto L8;
    L11:
        return false;
    L8:
        if ((r102 instanceof Boolean) == false) goto L11;
        return ((Boolean) r102).booleanValue();
    }

    public String getStringConfig(String r100) {
        Map<String, Object> r101 = this.mConfig;
        if (r101 != null) goto L5;
        return null;
    L5:
        Object r102 = r101.get(r100);
        if (r102 != null) goto L8;
    L11:
        return null;
    L8:
        if ((r102 instanceof String) == false) goto L11;
        return (String) r102;
    }

    public void setEnableJSGroupThread(boolean r100) {
        this.mEnableJSGroupThread = r100;
    }

    public void setJSGroupThreadName(String r100) {
        this.mJSGroupThreadName = r100;
    }

    public static LynxGroup Create(a r100) {
        return r100.a();
    }

    public static LynxGroup Create(String r100, String[] r101) {
        return Create(r100, r101, false, false);
    }

    public static LynxGroup Create(String r100, String[] r101, boolean r102, boolean r103) {
        return Create(r100, r101, r102, r103, false);
    }

    public static LynxGroup Create(String r100, String[] r101, boolean r102, boolean r103, boolean r110) {
        return Create(r100, generateID(), r101, r102, r103, r110);
    }

    public static LynxGroup Create(String r100, String r101, String[] r102, boolean r103, boolean r110) {
        return Create(r100, r101, r102, r103, r110, false);
    }

    public static LynxGroup Create(String r100, String[] r101, boolean r102, boolean r103, boolean r110, boolean r111) {
        String r104 = generateID();
        if (r103 == true) goto L7;
        if (r111 == true) goto L7;
        boolean r105 = false;
    L9:
        return Create(r100, r104, r101, r102, r105, r110);
    L7:
        r105 = true;
        goto L9
    }

    public static LynxGroup Create(String r110, String r111, String[] r112, boolean r113, boolean r114, boolean r115) {
        return new LynxGroup(r110, r111, r112, r113, r114, r115, Boolean.FALSE, false);
    }

    public static LynxGroup Create(String r100, String r101, String[] r102, boolean r103, boolean r110, boolean r111, boolean r112) {
        if (r110 == true) goto L6;
        if (r112 == true) goto L6;
        boolean r104 = false;
    L8:
        return Create(r100, r101, r102, r103, r104, r111);
    L6:
        r104 = true;
        goto L8
    }

    public LynxGroup(String r100, String r101, String[] r102, boolean r103, boolean r104, boolean r105, Boolean r106, boolean r107) {
        this.mGroupName = r100;
        this.mID = r101;
        this.mPreloadJSPaths = r102;
        if (r106 != null) goto L5;
        this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
    L6:
        if (r107 == false) goto L8;
        this.mWhiteBoard = new LynxWhiteBoard();
    L8:
        this.mEnableV8 = r105;
        this.mEnableCanvas = r104;
        LLog.i("LynxGroup", "LynxGroup init with name " + r100 + ", id: " + r101 + ", enableV8: " + r105 + ", canvas:" + this.mEnableCanvas);
        return;
    L5:
        this.mEnableJSGroupThread = r106.booleanValue();
        goto L6
    }
}
