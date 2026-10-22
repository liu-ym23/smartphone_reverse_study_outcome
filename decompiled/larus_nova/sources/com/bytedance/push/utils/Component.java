package com.bytedance.push.utils;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class Component {
    public String authorities;
    public List<IntentFilter> intentFilter;
    public String name;
    public String permission;
    public String processName;

    public static class Builder {

        /* JADX INFO: renamed from: component, reason: collision with root package name */
        private Component f267051component;

        public Component build() {
            return this.f267051component;
        }

        public Builder(String r100) {
            this.f267051component = new Component(r100);
        }

        public static Builder create(String r100) {
            return new Builder(r100);
        }

        public Builder addIntentFilter(IntentFilter r100) {
            if (r100 != null) goto L4;
            return this;
        L4:
            this.f267051component.intentFilter.add(r100);
            return this;
        }

        public Builder setAuthorities(String r100) {
            this.f267051component.authorities = r100;
            return this;
        }

        public Builder setPermission(String r100) {
            this.f267051component.permission = r100;
            return this;
        }

        public Builder setProcess(String r100) {
            this.f267051component.processName = r100;
            return this;
        }
    }

    public static class IntentFilter {
        List<String> actions;
        List<String> categories;
        Uri data;
        String mimeType;

        public int hashCode() {
            List<String> r100 = this.actions;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.categories;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.mimeType;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Uri r110 = this.data;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "IntentFilter{actions=" + this.actions + ", categories=" + this.categories + ", data=" + this.data + ", mimetype=" + this.mimeType + '}';
        }

        public IntentFilter(List<String> r100) {
            this(r100, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof IntentFilter) == true) goto L8;
            return false;
        L8:
            IntentFilter r101 = (IntentFilter) r100;
            List<String> r102 = this.actions;
            if (r102 == null) goto L14;
            if (r102.equals(r101.actions) == false) goto L15;
        L16:
            List<String> r103 = this.categories;
            if (r103 == null) goto L22;
            if (r103.equals(r101.categories) == false) goto L23;
        L24:
            String r104 = this.mimeType;
            if (r104 == null) goto L30;
            if (r104.equals(r101.mimeType) == false) goto L31;
        L32:
            Uri r105 = this.data;
            Uri r106 = r101.data;
            if (r105 != null) goto L39;
            if (r106 == null) goto L40;
            return false;
        L40:
            return true;
        L39:
            return r105.equals(r106);
        L31:
            return false;
        L30:
            if (r101.mimeType == null) goto L32;
        L23:
            return false;
        L22:
            if (r101.categories == null) goto L24;
        L15:
            return false;
        L14:
            if (r101.actions == null) goto L16;
            goto L15
        }

        public IntentFilter(List<String> r100, List<String> r101) {
            this.actions = r100;
            this.categories = r101;
        }

        public IntentFilter(List<String> r100, List<String> r101, Uri r102) {
            this.actions = r100;
            this.categories = r101;
            this.data = r102;
        }

        public IntentFilter(List<String> r100, List<String> r101, String r102) {
            this.actions = r100;
            this.categories = r101;
            this.mimeType = r102;
        }
    }

    public int hashCode() {
        List<IntentFilter> r100 = this.intentFilter;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.processName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.permission;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.authorities;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Component{name='" + this.name + "', intentFilter=" + this.intentFilter + ", processName='" + this.processName + "', permission='" + this.permission + "', authorities='" + this.authorities + "'}";
    }

    public Component(String r100) {
        this.intentFilter = new ArrayList();
        this.name = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Component) == true) goto L8;
        return false;
    L8:
        Component r101 = (Component) r100;
        List<IntentFilter> r102 = this.intentFilter;
        if (r102 == null) goto L14;
        if (r102.equals(r101.intentFilter) == false) goto L15;
    L16:
        String r103 = this.name;
        if (r103 == null) goto L22;
        if (r103.equals(r101.name) == false) goto L23;
    L24:
        String r104 = this.processName;
        if (r104 == null) goto L30;
        if (r104.equals(r101.processName) == false) goto L31;
    L32:
        String r105 = this.permission;
        if (r105 == null) goto L38;
        if (r105.equals(r101.permission) == false) goto L39;
    L40:
        String r106 = this.authorities;
        String r107 = r101.authorities;
        if (r106 != null) goto L43;
        if (r107 == null) goto L47;
    L46:
        return false;
    L47:
        return true;
    L43:
        if (r106.equals(r107) == true) goto L47;
    L39:
        return false;
    L38:
        if (r101.permission == null) goto L40;
    L31:
        return false;
    L30:
        if (r101.processName == null) goto L32;
    L23:
        return false;
    L22:
        if (r101.name == null) goto L24;
    L15:
        return false;
    L14:
        if (r101.intentFilter == null) goto L16;
        goto L15
    }

    private static boolean equalsInternal(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }
}
