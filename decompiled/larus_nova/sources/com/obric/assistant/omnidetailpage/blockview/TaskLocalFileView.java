package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.localmedia.TaskLocalAudioButtonView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0007H\u0002J\f\u0010#\u001a\u00020\u0016*\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskLocalFileView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardView", "Landroid/widget/LinearLayout;", "iconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "titleView", "Landroid/widget/TextView;", "typeView", "playButton", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioButtonView;", "boundPath", "", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$LocalFile;", "onRecycled", "refreshPlayButton", "path", "resolveColor", "attrRes", "colorRes", "showAudioOpenFailedToast", "showAudioFileNotExistToast", "showAudioFailureToast", "messageRes", "setCardBackground", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskLocalFileView extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f390586i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f390587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f390588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f390589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f390590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TaskLocalAudioButtonView f390591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f390592h;

    public TaskLocalFileView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskLocalFileView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void setCardBackground(LinearLayout r100) {
        r100.setBackgroundResource(R.drawable.obric_omni_bg_quick_reply);
    }

    public TaskLocalFileView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LinearLayout r113 = new LinearLayout(r110);
        r113.setOrientation(0);
        r113.setGravity(16);
        r113.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        setCardBackground(r113);
        this.f390587c = r113;
        SimpleDraweeView r100 = new SimpleDraweeView(r110);
        this.f390588d = r100;
        TextView r101 = new TextView(r110);
        r101.setTextSize(0, i5.q());
        r101.setTypeface(Typeface.create("PingFang SC", 0));
        r101.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        this.f390589e = r101;
        TextView r102 = new TextView(r110);
        r102.setTextSize(0, i5.m());
        r102.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50)));
        r102.setMaxLines(1);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        this.f390590f = r102;
        TaskLocalAudioButtonView r103 = new TaskLocalAudioButtonView(r110, null, 6, 0);
        this.f390591g = r103;
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(i5.q(), i5.j0(), i5.q(), i5.j0());
        addView(r113, new FrameLayout.LayoutParams(-1, -2));
        r113.addView(r100, new LinearLayout.LayoutParams(i5.E(), i5.E()));
        LinearLayout r104 = new LinearLayout(r110);
        r104.setOrientation(1);
        r104.setGravity(16);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r114.setMarginStart(i5.q());
        r114.setMarginEnd(i5.q());
        r113.addView(r104, r114);
        r104.addView(r101, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -2);
        r115.topMargin = i5.Y();
        Unit r116 = Unit.INSTANCE;
        r104.addView(r102, r115);
        r113.addView(r103, new LinearLayout.LayoutParams(i5.J(), i5.J()));
    }

    public /* synthetic */ TaskLocalFileView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
