package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.a;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/SettingEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SettingEntranceView extends ConstraintLayout {
    public final View a;
    public FrameLayout b;

    public SettingEntranceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SettingEntranceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SettingEntranceView(final Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ViewGroup.inflate(r4, 2131567447, this);
        ImageView r7 = (ImageView) findViewById(2131386004);
        View r8 = findViewById(2131386011);
        this.a = r8;
        MultiChorusContext.Companion.getClass();
        if (MultiChorusContext.a.d() == false) goto L14;
        MutableLiveData<d> r9 = KtvComponentContext.Companion.a();
        if (r9 == null) goto L14;
        d r10 = (d) r9.getValue();
        if (r10 == null) goto L14;
        if (r10.a != true) goto L14;
        if (((Boolean) c.o0.getValue()).booleanValue() == false) goto L14;
        if (r8 == null) goto L16;
        r8.setVisibility(0);
    L16:
        setOnClickListener(x0.a(new AnonymousClass1(this, r4)));
        if (a.a().isVirtualLive() == false) goto L19;
    L23:
        setVisibility(8);
        return;
    L19:
        if (j.i() == false) goto L21;
    L22:
        setVisibility(0);
        return;
    L21:
        if (KtvUtilsKt.j() == false) goto L23;
    L14:
        if (r8 == null) goto L16;
        r8.setVisibility(8);
        goto L16
    }

    public /* synthetic */ SettingEntranceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
