package com.obric.oui.image;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/image/OImageShape;", "", "", "attrValue", "I", "getAttrValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STANDARD", "ROUNDED", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OImageShape extends Enum<OImageShape> {
    public static final a Companion = null;
    public static final OImageShape ROUNDED = null;
    public static final OImageShape STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OImageShape[] f401078a = null;
    private final int attrValue;

    public static final class a {
        public a() {
        }
    }

    public static OImageShape valueOf(String r100) {
        return (OImageShape) r27.a.a(OImageShape.class, r100);
    }

    public static OImageShape[] values() {
        return (OImageShape[]) f401078a.clone();
    }

    static {
        OImageShape r100 = new OImageShape("STANDARD", 0, 0);
        STANDARD = r100;
        OImageShape r101 = new OImageShape("ROUNDED", 1, 1);
        ROUNDED = r101;
        f401078a = new OImageShape[]{r100, r101};
        Companion = new a();
    }

    public final int getAttrValue() {
        return this.attrValue;
    }

    public OImageShape(String r100, int r101, int r102) {
        super(r100, r101);
        this.attrValue = r102;
    }
}
