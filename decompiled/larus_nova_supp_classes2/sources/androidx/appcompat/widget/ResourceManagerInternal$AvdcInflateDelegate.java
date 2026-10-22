package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResourceManagerInternal$AvdcInflateDelegate implements ResourceManagerInternal$InflateDelegate {
    public ResourceManagerInternal$AvdcInflateDelegate() {
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
    public Drawable createFromXmlInner(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
        return AnimatedVectorDrawableCompat.createFromXmlInner(r2, r2.getResources(), r3, r4, r5);
    L4:
        return null;
    }
}
