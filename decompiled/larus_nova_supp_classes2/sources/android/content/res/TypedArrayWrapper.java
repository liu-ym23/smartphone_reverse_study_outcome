package android.content.res;

import android.graphics.drawable.Drawable;
import com.bytedance.mira.MiraManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TypedArrayWrapper extends TypedArray {
    public TypedArrayWrapper(Resources r1) {
        super(r1);
    }

    @Override // android.content.res.TypedArray
    public Drawable getDrawable(int r2) {
        Drawable r3 = super.getDrawable(r2);
        MiraManager.getInstance().getParam().getResourceIdVisitor();
        return r3;
    }
}
