package com.bytedance.locallife.live.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/live/model/AtmosphereShowType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Show", "Hide", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum AtmosphereShowType extends Enum<AtmosphereShowType> {
    public static final a Companion = null;
    public static final AtmosphereShowType Hide = null;
    public static final AtmosphereShowType Show = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtmosphereShowType[] f260617a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static AtmosphereShowType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            AtmosphereShowType r101 = AtmosphereShowType.Show;
            if (Intrinsics.areEqual(r100, r101.getValue()) == false) goto L6;
            return r101;
        L6:
            return AtmosphereShowType.Hide;
        }
    }

    public static AtmosphereShowType valueOf(String r100) {
        return (AtmosphereShowType) r27.a.a(AtmosphereShowType.class, r100);
    }

    public static AtmosphereShowType[] values() {
        return (AtmosphereShowType[]) f260617a.clone();
    }

    static {
        AtmosphereShowType r100 = new AtmosphereShowType("Show", 0, "show");
        Show = r100;
        AtmosphereShowType r101 = new AtmosphereShowType("Hide", 1, "hide");
        Hide = r101;
        f260617a = new AtmosphereShowType[]{r100, r101};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public AtmosphereShowType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
