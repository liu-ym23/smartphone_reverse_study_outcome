package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLifeShelfTextComponentView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeShelfTextComponentView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f260265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f260266b;

    public LiveLifeShelfTextComponentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeShelfTextComponentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(x r100) {
        Intrinsics.checkNotNullParameter(r100, "uiData");
        this.f260265a.setText(r100.e());
        Float r101 = r100.d();
        boolean r102 = true;
        if (r101 == null) goto L5;
        float r103 = r101.floatValue();
        this.f260265a.setTextSize(1, r103);
    L5:
        String r104 = r100.c();
        if (r104 == null) goto L8;
        this.f260265a.setTextColor(com.bytedance.locallife.live.util.b.a(r104));
    L8:
        Integer r105 = r100.f();
        if (r105 == null) goto L11;
        int r106 = r105.intValue();
        this.f260265a.setMaxLines(r106);
    L11:
        Boolean r107 = r100.a();
        Unit r108 = null;
        if (r107 != null) goto L14;
    L17:
        Integer r109 = r100.b();
        if (r109 == null) goto L24;
        int r110 = r109.intValue();
        View r111 = this.f260266b;
        if (r110 == 2) goto L23;
        r102 = false;
    L23:
        n.h(r111, r102);
        r108 = Unit.INSTANCE;
    L24:
        if (r108 != null) goto L27;
        n.h(this.f260266b, false);
        return;
    L27:
        return;
    L14:
        if (r107.booleanValue() == false) goto L16;
        this.f260265a.setEllipsize(TextUtils.TruncateAt.END);
        goto L17
    L16:
        this.f260265a.setEllipsize(null);
        goto L17
    }

    public LiveLifeShelfTextComponentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_live_life_shelf_text_component_view, this, true);
        setOrientation(0);
        setGravity(16);
        this.f260265a = (DuxTextView) findViewById(R.id.live_life_shelf_text_tv);
        this.f260266b = findViewById(R.id.live_life_shelf_text_splitter);
    }

    public /* synthetic */ LiveLifeShelfTextComponentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
