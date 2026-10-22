package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/AnchorContainer;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "GALLERY_PIC", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorContainer extends Enum<AnchorContainer> {
    public static final a Companion = null;
    public static final AnchorContainer GALLERY_PIC = null;
    public static final /* synthetic */ AnchorContainer[] a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static AnchorContainer a(String r5) {
            AnchorContainer[] r0 = AnchorContainer.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            AnchorContainer r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getValue(), r5) == true) goto L12;
            r2 = r2 + 1;
            goto L3
        L12:
            return r3;
        L8:
            return null;
        }
    }

    static {
        AnchorContainer r1 = new AnchorContainer();
        GALLERY_PIC = r1;
        a = new AnchorContainer[]{r1};
        Companion = new a();
    }

    public static AnchorContainer valueOf(String r1) {
        return (AnchorContainer) r27.a.a(AnchorContainer.class, r1);
    }

    public static AnchorContainer[] values() {
        return (AnchorContainer[]) a.clone();
    }

    public AnchorContainer() {
        super("GALLERY_PIC", 0);
        this.value = "gallery_pic";
    }

    public final String getValue() {
        return this.value;
    }
}
