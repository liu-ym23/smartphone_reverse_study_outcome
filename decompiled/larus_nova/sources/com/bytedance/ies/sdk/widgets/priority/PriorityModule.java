package com.bytedance.ies.sdk.widgets.priority;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class PriorityModule implements Cloneable {
    public static final String OPERATOR_ADD = "add";
    public static final String OPERATOR_CLEAR = "clear";
    public static final String OPERATOR_MODIFY = "modify";
    public static final String OPERATOR_REMOVE = "remove";
    public static final String OPERATOR_REPLACE = "replace";
    public static final String SCENE_ALL = "all";
    public static final String SCENE_AUDIO = "audio";
    public static final String SCENE_EC = "ec";
    public static final String SCENE_GAME = "game";
    public static final String SCENE_MATCH = "match";
    public static final String SCENE_MEDIA = "media";
    public static final String SCENE_MULTI = "multi";
    public static final String SCENE_THIRD_PARTY = "third_party";
    public static final String SCENE_VIDEO = "video";
    public static final String SCENE_VS_LIVE = "vs_live";
    public List<WidgetScene> scenes;
    public boolean splitFrame;

    public static class Opportunity {
        public static final String OP_OTHER = "other";
        public static final String OP_P0 = "p0";
        public static final String OP_P1 = "p1";
        public static final String OP_P2 = "p2";
        public List<WidgetGroup> groups;
        public String opName;

        public Opportunity() {
        }

        public boolean isEmpty() {
            List<WidgetGroup> r100 = this.groups;
            if (r100 != null) goto L5;
        L8:
            return true;
        L5:
            if (r100.isEmpty() == true) goto L8;
            return false;
        }

        public boolean isValidate() {
            if (TextUtils.equals(this.opName, "p0") == false) goto L5;
        L12:
            return true;
        L5:
            if (TextUtils.equals(this.opName, "p1") == true) goto L12;
            if (TextUtils.equals(this.opName, "p2") == true) goto L12;
            if (TextUtils.equals(this.opName, "other") == true) goto L12;
            return false;
        }

        public List<WidgetInfo> getAllWidgets() {
            if (isEmpty() == false) goto L6;
            return null;
        L6:
            ArrayList r100 = new ArrayList();
            Iterator<WidgetGroup> r101 = this.groups.iterator();
        L8:
            if (r101.hasNext() == false) goto L13;
            WidgetGroup r102 = r101.next();
            if (r102.isEmpty() == true) goto L8;
            r100.addAll(r102.widgets);
            goto L8
        L13:
            return r100;
        }

        public void addGroup(WidgetGroup r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.groups != null) goto L7;
            this.groups = new ArrayList();
        L7:
            this.groups.add(r100);
            Collections.sort(this.groups, new AnonymousClass1(this));
        }

        public void addGroups(List<WidgetGroup> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isEmpty() == false) goto L7;
            return;
        L7:
            if (this.groups != null) goto L9;
            this.groups = new ArrayList();
        L9:
            Iterator<WidgetGroup> r101 = r100.iterator();
        L11:
            if (r101.hasNext() == false) goto L22;
            WidgetGroup r102 = r101.next();
            if (hasGroup(r102) == true) goto L11;
            this.groups.add(r102);
            goto L11
        }

        public WidgetGroup getGroup(String r100) {
            if (isEmpty() == false) goto L5;
        L13:
            return null;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L13;
            Iterator<WidgetGroup> r101 = this.groups.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            WidgetGroup r102 = r101.next();
            if (TextUtils.equals(r100, r102.groupName) == false) goto L9;
            return r102;
        }

        public boolean hasGroup(WidgetGroup r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            Iterator<WidgetGroup> r101 = this.groups.iterator();
        L7:
            if (r101.hasNext() == false) goto L12;
            WidgetGroup r102 = r101.next();
            if (TextUtils.equals(r100.groupName, r102.groupName) == false) goto L7;
            return true;
        L12:
            return false;
        }

        public void removeGroup(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            Iterator<WidgetGroup> r101 = this.groups.iterator();
        L7:
            if (r101.hasNext() == false) goto L11;
            WidgetGroup r102 = r101.next();
            if (TextUtils.equals(r100, r102.groupName) == false) goto L7;
        L12:
            this.groups.remove(r102);
            return;
        L11:
            r102 = null;
            goto L12
        }

        public void removeGroups(List<WidgetGroup> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isEmpty() == true) goto L12;
            Iterator<WidgetGroup> r101 = r100.iterator();
        L8:
            if (r101.hasNext() == false) goto L13;
            removeGroup(r101.next().groupName);
            goto L8
        L13:
            return;
        }
    }

    public static class WidgetGroup {
        public String groupName;
        public String operator;
        public int priority;
        public boolean showTogether;
        public List<WidgetInfo> widgets;

        public WidgetGroup() {
        }

        public boolean isEmpty() {
            List<WidgetInfo> r100 = this.widgets;
            if (r100 != null) goto L5;
        L8:
            return true;
        L5:
            if (r100.isEmpty() == true) goto L8;
            return false;
        }

        public void addWidgets(List<WidgetInfo> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isEmpty() == false) goto L7;
            return;
        L7:
            if (this.widgets != null) goto L9;
            this.widgets = new ArrayList();
        L9:
            Iterator<WidgetInfo> r101 = r100.iterator();
        L11:
            if (r101.hasNext() == false) goto L15;
            WidgetInfo r102 = r101.next();
            if (hasWidget(r102) == true) goto L11;
            this.widgets.add(r102);
            goto L11
        L15:
            Collections.sort(this.widgets, new AnonymousClass1(this));
        }

        public boolean hasWidget(WidgetInfo r100) {
            List<WidgetInfo> r101 = this.widgets;
            if (r101 != null) goto L5;
        L14:
            return false;
        L5:
            if (r101.isEmpty() == true) goto L14;
            Iterator<WidgetInfo> r102 = this.widgets.iterator();
        L9:
            if (r102.hasNext() == false) goto L14;
            WidgetInfo r103 = r102.next();
            if (TextUtils.equals(r100.widget, r103.widget) == false) goto L9;
            return true;
        }

        public void removeWidget(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            Iterator<WidgetInfo> r101 = this.widgets.iterator();
        L7:
            if (r101.hasNext() == false) goto L11;
            WidgetInfo r102 = r101.next();
            if (TextUtils.equals(r100, r102.widget) == false) goto L7;
        L12:
            this.widgets.remove(r102);
            return;
        L11:
            r102 = null;
            goto L12
        }

        public void removeWidgets(List<WidgetInfo> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isEmpty() == true) goto L12;
            Iterator<WidgetInfo> r101 = r100.iterator();
        L8:
            if (r101.hasNext() == false) goto L13;
            removeWidget(r101.next().widget);
            goto L8
        L13:
            return;
        }
    }

    public static class WidgetInfo {
        public boolean isAsync;
        public boolean isBlockGroup;
        public boolean isBlockWidget;
        public int priority;
        public String widget;

        public WidgetInfo() {
        }
    }

    public static class WidgetScene implements Cloneable {
        public List<String> frameLoadList;
        public String operator;
        public List<Opportunity> opportunity;
        public String sceneName;

        public WidgetScene() {
        }

        public boolean isEmpty() {
            List<Opportunity> r100 = this.opportunity;
            if (r100 != null) goto L5;
        L8:
            return true;
        L5:
            if (r100.isEmpty() == true) goto L8;
            return false;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Opportunity getOpportunity(String r100) {
            if (isEmpty() == false) goto L5;
        L13:
            return null;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L13;
            Iterator<Opportunity> r101 = this.opportunity.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            Opportunity r102 = r101.next();
            if (TextUtils.equals(r100, r102.opName) == false) goto L9;
            return r102;
        }

        public int getWidgetLevel(String r100) {
            if (isEmpty() == false) goto L5;
            return -1;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L41;
            Iterator<Opportunity> r101 = this.opportunity.iterator();
        L9:
            if (r101.hasNext() == false) goto L25;
            Opportunity r102 = r101.next();
            List<WidgetGroup> r103 = r102.groups;
            if (r103 == null) goto L9;
            Iterator<WidgetGroup> r104 = r103.iterator();
        L15:
            if (r104.hasNext() == false) goto L9;
            List<WidgetInfo> r105 = r104.next().widgets;
            if (r105 == null) goto L15;
            Iterator<WidgetInfo> r106 = r105.iterator();
        L21:
            if (r106.hasNext() == false) goto L15;
            if (TextUtils.equals(r100, r106.next().widget) == false) goto L21;
            String r107 = r102.opName;
        L27:
            return PriorityModule.opNameToLevel(r107);
        L25:
            r107 = null;
            goto L27
        L41:
            return -1;
        }

        public void removeGroups(List<Opportunity> r100) {
            Iterator<Opportunity> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            Opportunity r102 = r101.next();
            Opportunity r103 = getOpportunity(r102.opName);
            if (r103 == null) goto L4;
            r103.removeGroups(r102.groups);
            goto L4
        }
    }

    public PriorityModule() {
    }

    public boolean isEmpty() {
        List<WidgetScene> r100 = this.scenes;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static int opNameToLevel(String r100) {
        if (TextUtils.equals(r100, "p0") == false) goto L7;
        return 0;
    L7:
        if (TextUtils.equals(r100, "p1") == false) goto L11;
        return 1;
    L11:
        if (TextUtils.equals(r100, "p2") == false) goto L15;
        return 2;
    L15:
        if (TextUtils.equals(r100, "other") == false) goto L18;
        return 3;
    L18:
        return -1;
    }

    public void addScene(WidgetScene r100) {
        if (this.scenes != null) goto L6;
        this.scenes = new ArrayList();
    L6:
        if (hasScene(r100) == true) goto L9;
        this.scenes.add(r100);
        return;
    }

    public WidgetScene getScene(String r100) {
        if (isEmpty() == false) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        Iterator<WidgetScene> r101 = this.scenes.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        WidgetScene r102 = r101.next();
        if (TextUtils.equals(r100, r102.sceneName) == false) goto L9;
        return r102;
    }

    public boolean hasScene(WidgetScene r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<WidgetScene> r101 = this.scenes.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        WidgetScene r102 = r101.next();
        if (TextUtils.equals(r100.sceneName, r102.sceneName) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void removeScene(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Iterator<WidgetScene> r101 = this.scenes.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        WidgetScene r102 = r101.next();
        if (TextUtils.equals(r100, r102.sceneName) == false) goto L7;
    L12:
        this.scenes.remove(r102);
        return;
    L11:
        r102 = null;
        goto L12
    }
}
