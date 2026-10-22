package com.larus.bmhome.chat.markdown.richtext;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class AvatarBinding implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f307171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f307172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Job> f307173c;

    public final void a() {
        Iterator<T> r100 = this.f307173c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r100.next(), null, 1, null);
        goto L4
    L6:
        ((ArrayList) this.f307173c).clear();
    }

    public final void b() {
        a();
        LifecycleOwner r100 = ViewTreeLifecycleOwner.get(this.f307171a);
        if (r100 == null) goto L28;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L41;
        List<d> r102 = this.f307172b;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        p r106 = ((d) r105).f307183b;
        Object r107 = r103.get(r106);
        if (r107 != null) goto L13;
        r107 = new ArrayList();
        r103.put(r106, r107);
    L13:
        ((List) r107).add(r105);
        goto L9
    L14:
        Iterator r108 = r103.entrySet().iterator();
    L16:
        if (r108.hasNext() == false) goto L42;
        Map.Entry r109 = (Map.Entry) r108.next();
        p r110 = (p) r109.getKey();
        List r111 = (List) r109.getValue();
        r110.getClass();
        MessageReferenceIconStore r112 = MessageReferenceIconStore.f308518a;
        String r113 = MessageReferenceIconStore.a(r110.f307229a, r110.f307230b, r110.f307231c);
        if (r113 == null) goto L16;
        MessageReferenceIconStore r114 = MessageReferenceIconStore.f308518a;
        Intrinsics.checkNotNullParameter(r113, "cacheKey");
        Bitmap r115 = MessageReferenceIconStore.e(r113);
        if (r115 != null) goto L22;
        List<Job> r116 = this.f307173c;
        ArrayList r117 = (ArrayList) r116;
        r117.add(BuildersKt.launch$default(r101, null, null, new AvatarBinding$load$2$2(this, r110, r113, r111, null), 3, null));
        goto L16
    L22:
        Iterator r118 = r111.iterator();
    L24:
        if (r118.hasNext() == false) goto L26;
        d r119 = (d) r118.next();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r113, "cacheKey");
        Intrinsics.checkNotNullParameter(r115, SimplayerImageStrategy.RESULT_BITMAP);
        r119.f307186e = r113;
        RoundedBitmapDrawable r120 = RoundedBitmapDrawableFactory.create(r119.f307182a, r115);
        r120.setCircular(true);
        r119.f307187f = r120;
        goto L24
    L26:
        this.f307171a.invalidate();
        goto L16
    L42:
        return;
    L41:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        a();
    }

    public AvatarBinding(TextView r100, List<d> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "spans");
        this.f307171a = r100;
        this.f307172b = r101;
        this.f307173c = new ArrayList();
    }
}
