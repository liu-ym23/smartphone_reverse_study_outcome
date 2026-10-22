package com.bytedance.ies.sdk.widgets.priority;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class PriorityManager {
    private PriorityModule currentModule;
    private PriorityModule defaultModule;
    private PriorityModule diffModule;
    private final Gson gson;

    /* JADX INFO: renamed from: com.bytedance.ies.sdk.widgets.priority.PriorityManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class WidgetPriorityManagerHolder {
        private static final PriorityManager instance = null;

        private WidgetPriorityManagerHolder() {
        }

        static {
            instance = new PriorityManager(null);
        }

        public static /* synthetic */ PriorityManager access$100() {
            return instance;
        }
    }

    private PriorityManager() {
        this.gson = new Gson();
    }

    public static PriorityManager getInstance() {
        return WidgetPriorityManagerHolder.access$100();
    }

    public PriorityModule getPriorityModule() {
        return this.currentModule;
    }

    public /* synthetic */ PriorityManager(AnonymousClass1 r100) {
        this();
    }

    public void initDefaultPriority(Context r100) {
        boolean r101 = WidgetService.getInstance().isNewPriority();
        WidgetService.getInstance().aLogI("【widget】", "initDefaultPriority " + r101);
        if (r101 == true) goto L6;
        return;
    L6:
        if (this.defaultModule != null) goto L9;
        this.defaultModule = (PriorityModule) getFromAssets(r100, "widget_default_priority.json", PriorityModule.class);
        return;
    }

    public void updateDiffConfig(PriorityModule r100) {
        boolean r101 = WidgetService.getInstance().isNewPriority();
        WidgetService.getInstance().aLogI("【widget】", "updateDiffConfig " + r101);
        if (r101 == true) goto L6;
        return;
    L6:
        if (this.diffModule != null) goto L19;
        if (r100 == null) goto L20;
        PriorityModule r102 = this.defaultModule;
        if (r102 == null) goto L21;
        this.diffModule = r100;
        this.currentModule = (PriorityModule) r102.clone();     // Catch: CloneNotSupportedException -> L13
    L15:
        mergeScene(this.currentModule, r100);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L21:
        return;
    L20:
        return;
    }

    private String getStringFromAssets(Context r100, String r101) {
        InputStream r102 = null;
        r102 = r100.getAssets().open(r101);     // Catch: Throwable -> L8
        byte[] r103 = new byte[r102.available()];     // Catch: Throwable -> L8
        r102.read(r103);     // Catch: Throwable -> L8
        String r104 = new String(r103, "UTF-8");     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L6
        return r104;
    L6:
        e = move-exception;
        e.printStackTrace();
        return r104;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        if (r102 != null) goto L32;
    L15:
        return "";
    L32:
        r102.close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = move-exception;
        if (r102 != null) goto L24;
    L23:
        throw th;
    L24:
        r102.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private void mergeGroup(PriorityModule.WidgetScene r100, List<PriorityModule.Opportunity> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isEmpty() == true) goto L76;
        if (r100 == null) goto L77;
        Iterator<PriorityModule.Opportunity> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L78;
        PriorityModule.Opportunity r103 = r102.next();
        if (r103.isValidate() == false) goto L9;
        Iterator<PriorityModule.WidgetGroup> r104 = r103.groups.iterator();
    L15:
        if (r104.hasNext() == false) goto L9;
        PriorityModule.WidgetGroup r105 = r104.next();
        PriorityModule.WidgetGroup r106 = r103.getGroup(r105.groupName);
        String r107 = r105.operator;
        if (r107 == null) goto L15;
        r107.getClass();
        byte r108 = -1;
        switch(r107.hashCode()) {
            case -934610812: goto L35;
            case 96417: goto L31;
            case 94746189: goto L27;
            case 1094496948: goto L23;
            default: goto L38;
        };
    L38:
        switch(r108) {
            case 0: goto L47;
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L40;
            default: goto L15;
        };
    L40:
        if (r106 == null) goto L15;
        r103.removeGroup(r105.groupName);
        r103.addGroup(r105);
        goto L15
    L42:
        if (r106 == null) goto L15;
        r103.removeGroup(r105.groupName);
        goto L15
    L44:
        if (r106 == null) goto L45;
        r106.addWidgets(r105.widgets);
        goto L15
    L45:
        r103.addGroup(r105);
        goto L15
    L47:
        if (r106 == null) goto L15;
        r106.removeWidgets(r105.widgets);
        goto L15
    L23:
        if (r107.equals("replace") == false) goto L38;
        r108 = 3;
        goto L38
    L27:
        if (r107.equals("clear") == false) goto L38;
        r108 = 2;
        goto L38
    L31:
        if (r107.equals("add") == false) goto L38;
        r108 = 1;
        goto L38
    L35:
        if (r107.equals("remove") == false) goto L38;
        r108 = 0;
        goto L38
    L78:
        return;
    L77:
        return;
    }

    private void mergeScene(PriorityModule r100, PriorityModule r101) {
        WidgetService.getInstance().aLogI("【widget】", "mergeScene");
        if (r101 == null) goto L25;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r101.isEmpty() == false) goto L9;
        return;
    L9:
        if (r100.isEmpty() == true) goto L37;
        Iterator<PriorityModule.WidgetScene> r102 = r101.scenes.iterator();
    L13:
        if (r102.hasNext() == false) goto L38;
        PriorityModule.WidgetScene r103 = r102.next();
        if (TextUtils.isEmpty(r103.sceneName) == true) goto L13;
        String[] r104 = r103.sceneName.split(",");
        int r105 = r104.length;
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L13;
        String r107 = r104[r106];
        PriorityModule.WidgetScene r108 = r100.getScene(r107);
        PriorityModule.WidgetScene r109 = (PriorityModule.WidgetScene) r103.clone();     // Catch: CloneNotSupportedException -> L22
        r109.sceneName = r107;     // Catch: CloneNotSupportedException -> L22
        mergeSceneInner(r100, r109, r108);     // Catch: CloneNotSupportedException -> L22
    L24:
        r106 = r106 + 1;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L38:
        return;
    L37:
        return;
    }

    private <T> T getFromAssets(Context r100, String r101, Class<T> r102) {
        T r103 = null;
        InputStreamReader r104 = new InputStreamReader(r100.getAssets().open(r101));     // Catch: Throwable -> L11
        r103 = (T) this.gson.fromJson(r104, r102);
        r104.close();     // Catch: IOException -> L7
    L24:
    L16:
        return r103;
    L9:
        th = th;
    L29:
        th.printStackTrace();     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
        r104.close();     // Catch: IOException -> L7
    L17:
        th = move-exception;
        if (r104 != null) goto L27;
    L23:
        throw th;
    L27:
        r104.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        th = th;
        r104 = null;
        goto L29
    }

    private void mergeSceneInner(PriorityModule r100, PriorityModule.WidgetScene r101, PriorityModule.WidgetScene r102) {
        String r103 = r101.operator;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.getClass();
        byte r104 = -1;
        switch(r103.hashCode()) {
            case -1068795718: goto L25;
            case -934610812: goto L21;
            case 96417: goto L17;
            case 94746189: goto L13;
            case 1094496948: goto L9;
            default: goto L28;
        };
    L28:
        switch(r104) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            default: goto L51;
        };
    L30:
        if (r102 == null) goto L42;
        r100.removeScene(r101.sceneName);
        r100.addScene(r101);
        return;
    L42:
        return;
    L32:
        if (r102 == null) goto L44;
        r100.removeScene(r101.sceneName);
        return;
    L44:
        return;
    L34:
        if (r102 != null) goto L36;
        r100.addScene(r101);
        return;
    L36:
        r102.frameLoadList = r101.frameLoadList;
        mergeGroup(r102, r101.opportunity);
        return;
    L37:
        if (r102 == null) goto L48;
        r102.removeGroups(r101.opportunity);
        return;
    L48:
        return;
    L39:
        if (r102 == null) goto L50;
        r102.frameLoadList = r101.frameLoadList;
        mergeGroup(r102, r101.opportunity);
        return;
    L50:
        return;
    L51:
        return;
    L9:
        if (r103.equals("replace") == false) goto L28;
        r104 = 4;
        goto L28
    L13:
        if (r103.equals("clear") == false) goto L28;
        r104 = 3;
        goto L28
    L17:
        if (r103.equals("add") == false) goto L28;
        r104 = 2;
        goto L28
    L21:
        if (r103.equals("remove") == false) goto L28;
        r104 = 1;
        goto L28
    L25:
        if (r103.equals(PriorityModule.OPERATOR_MODIFY) == false) goto L28;
        r104 = 0;
        goto L28
    }
}
