package com.ss.android.lark.thirdshare.panel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/ShareItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "shareItemIconFromXml", "Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "getShareItemIconFromXml", "()Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "setShareItemIconFromXml", "(Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;)V", "shareItemLabelFromXml", "Landroid/widget/TextView;", "getShareItemLabelFromXml", "()Landroid/widget/TextView;", "setShareItemLabelFromXml", "(Landroid/widget/TextView;)V", "setItemContent", "", "itemContent", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemContent;", "Companion", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareItemView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UDDimension.Dp f441274c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SquircleImageView f441275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f441276b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.thirdshare.panel.content.a f441277a;

        public b(com.ss.android.lark.thirdshare.panel.content.a r100) {
            this.f441277a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f441277a.getClass();
            throw null;
        }
    }

    static {
        f441274c = new UDDimension.Dp(64);
    }

    public final SquircleImageView getShareItemIconFromXml() {
        KeyEvent.Callback r100 = this.f441275a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_item_icon);
        this.f441275a = (SquircleImageView) r100;
    L6:
        return (SquircleImageView) r100;
    }

    public final TextView getShareItemLabelFromXml() {
        KeyEvent.Callback r100 = this.f441276b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_item_label);
        this.f441276b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public ShareItemView(Context r100) {
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share, this, true);
        setOrientation(1);
        setGravity(1);
    }

    public final void setItemContent(com.ss.android.lark.thirdshare.panel.content.a r100) {
        Intrinsics.checkNotNullParameter(r100, "itemContent");
        SquircleImageView r101 = getShareItemIconFromXml();
        r100.getClass();
        int r102 = UDColorUtils.getColor(r101.getContext(), R.color.icon_n1);
        r101.setImageDrawable(UDIconUtils.getIconDrawable(r101.getContext(), 0, r102));
        getShareItemLabelFromXml().setText(null);
        setOnClickListener(new b(r100));
    }

    public final void setShareItemIconFromXml(SquircleImageView r100) {
        this.f441275a = r100;
    }

    public final void setShareItemLabelFromXml(TextView r100) {
        this.f441276b = r100;
    }

    public ShareItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share, this, true);
        setOrientation(1);
        setGravity(1);
    }

    public ShareItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.item_share, this, true);
        setOrientation(1);
        setGravity(1);
    }
}
