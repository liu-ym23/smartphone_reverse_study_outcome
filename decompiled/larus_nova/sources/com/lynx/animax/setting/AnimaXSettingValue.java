package com.lynx.animax.setting;

import androidx.camera.core.processing.util.GLUtils;
import com.alipay.sdk.m.u.i;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class AnimaXSettingValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f380423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<String> f380424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SettingType f380425c;

    public static final enum SettingType extends Enum<SettingType> {
        public static final SettingType BOOLEAN = null;
        public static final SettingType COLLECTION = null;
        public static final SettingType DOUBLE = null;
        public static final SettingType LONG = null;
        public static final SettingType STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SettingType[] f380426a = null;

        static {
            SettingType r100 = new SettingType("STRING", 0);
            STRING = r100;
            SettingType r101 = new SettingType("COLLECTION", 1);
            COLLECTION = r101;
            SettingType r102 = new SettingType("BOOLEAN", 2);
            BOOLEAN = r102;
            SettingType r103 = new SettingType("LONG", 3);
            LONG = r103;
            SettingType r104 = new SettingType("DOUBLE", 4);
            DOUBLE = r104;
            f380426a = new SettingType[]{r100, r101, r102, r103, r104};
        }

        public static SettingType[] values() {
            return (SettingType[]) f380426a.clone();
        }

        public static SettingType valueOf(String r100) {
            return (SettingType) r27.a.a(SettingType.class, r100);
        }

        public SettingType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380427a = null;

        static {
            int[] r100 = new int[SettingType.values().length];
            f380427a = r100;
            r100[SettingType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f380427a[SettingType.COLLECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f380427a[SettingType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f380427a[SettingType.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f380427a[SettingType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final Collection<String> a() {
        if (this.f380425c != SettingType.COLLECTION) goto L6;
        return this.f380424b;
    L6:
        return Collections.emptyList();
    }

    public final String b() {
        if (this.f380425c == SettingType.STRING) goto L7;
        return "";
    L7:
        return this.f380423a;
    }

    public final boolean c() {
        if (this.f380425c != SettingType.COLLECTION) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.f380425c != SettingType.STRING) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{type=");
        r100.append(this.f380425c.name());
        r100.append(", value=");
        int r101 = a.f380427a[this.f380425c.ordinal()];
        String r102 = "";
        if (r101 != 1) goto L5;
        String r103 = this.f380423a;
        if (r103 == null) goto L28;
        r102 = r103;
    L28:
        r100.append(r102);
    L29:
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        if (r101 == 2) goto L17;
        if (r101 != 3) goto L9;
        r100.append("false");
        goto L29
    L9:
        if (r101 != 4) goto L11;
        r100.append("0");
        goto L29
    L11:
        if (r101 == 5) goto L13;
        r100.append("");
        goto L29
    L13:
        r100.append(GLUtils.VERSION_UNKNOWN);
        goto L29
    L17:
        if (this.f380424b == null) goto L24;
        r100.append('[');
        Collection<String> r104 = this.f380424b;
        StringBuilder r105 = new StringBuilder();
        Iterator<T> r106 = r104.iterator();
        if (r106.hasNext() == false) goto L23;
    L20:
        r105.append((CharSequence) r106.next());
        if (r106.hasNext() == false) goto L23;
        r105.append(", ");
    L23:
        r100.append(r105.toString());
        r100.append(']');
        goto L29
    L24:
        r100.append("[]");
        goto L29
    }

    public AnimaXSettingValue(String r100) {
        this.f380423a = r100;
        this.f380424b = null;
        this.f380425c = SettingType.STRING;
    }

    public AnimaXSettingValue(Collection<String> r100) {
        this.f380423a = null;
        this.f380424b = r100;
        this.f380425c = SettingType.COLLECTION;
    }
}
