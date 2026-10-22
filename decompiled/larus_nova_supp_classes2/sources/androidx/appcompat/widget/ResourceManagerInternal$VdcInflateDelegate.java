package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResourceManagerInternal$VdcInflateDelegate implements ResourceManagerInternal$InflateDelegate {
    public ResourceManagerInternal$VdcInflateDelegate() {
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
    public Drawable createFromXmlInner(Context r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) {
        return VectorDrawableCompat.createFromXmlInner(r1.getResources(), r2, r3, r4);
    L4:
        return null;
    }
}
