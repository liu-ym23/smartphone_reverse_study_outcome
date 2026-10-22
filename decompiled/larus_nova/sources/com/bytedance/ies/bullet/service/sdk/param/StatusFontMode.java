package com.bytedance.ies.bullet.service.sdk.param;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "aliasValue", "getAliasValue", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LIGHT", "DARK", "DEFAULT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum StatusFontMode extends Enum<StatusFontMode> {
    public static final a Companion = null;
    public static final StatusFontMode DARK = null;
    public static final StatusFontMode DEFAULT = null;
    public static final StatusFontMode LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusFontMode[] f248147a = null;
    private final String aliasValue;
    private final String value;

    public static final class a {
        public a() {
        }

        public static StatusFontMode a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "string");
            StatusFontMode[] r101 = StatusFontMode.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            StatusFontMode r104 = r101[r103];
            if (Intrinsics.areEqual(r100, r104.getValue()) == false) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L18;
            r103 = r103 + 1;
            goto L3
        L18:
            return r104;
        L7:
            if (Intrinsics.areEqual(r100, r104.getAliasValue()) == true) goto L10;
            r105 = false;
            goto L11
        L14:
            return null;
        }
    }

    public static StatusFontMode valueOf(String r100) {
        return (StatusFontMode) r27.a.a(StatusFontMode.class, r100);
    }

    public static StatusFontMode[] values() {
        return (StatusFontMode[]) f248147a.clone();
    }

    static {
        StatusFontMode r100 = new StatusFontMode("LIGHT", 0, "light", "0");
        LIGHT = r100;
        StatusFontMode r101 = new StatusFontMode("DARK", 1, "dark", "1");
        DARK = r101;
        StatusFontMode r102 = new StatusFontMode("DEFAULT", 2, "default", "2");
        DEFAULT = r102;
        f248147a = new StatusFontMode[]{r100, r101, r102};
        Companion = new a();
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }

    public StatusFontMode(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.aliasValue = r103;
    }
}
