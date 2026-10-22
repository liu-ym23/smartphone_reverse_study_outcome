package com.lynx.animax.property;

/* JADX INFO: loaded from: classes32.dex */
public interface AnimaXValueCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXValueCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$getValueInternal(AnimaXValueCallback r100, float r110, float r111, AnimaXValueParam r112, AnimaXValueParam r113, float r114, float r115, float r116) {
            return r100.a(new a(r110, r111, r112, r113, r114, r115, r116));
        }
    }

    AnimaXValueParam a(a r100);

    Object getValueInternal(float r100, float r101, AnimaXValueParam r102, AnimaXValueParam r103, float r104, float r105, float r106);
}
