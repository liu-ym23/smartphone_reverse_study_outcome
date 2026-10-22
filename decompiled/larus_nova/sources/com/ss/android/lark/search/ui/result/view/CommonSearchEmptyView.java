package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j4c.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020 J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/CommonSearchEmptyView;", "Landroid/widget/RelativeLayout;", "Lcom/ss/android/lark/search/ui/result/view/ISearchResultEmptyView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mSearchResultEmptyView", "Landroid/view/View;", "getMSearchResultEmptyView", "()Landroid/view/View;", "setMSearchResultEmptyView", "(Landroid/view/View;)V", "mSearchEmptyHintText", "Landroid/widget/TextView;", "getMSearchEmptyHintText", "()Landroid/widget/TextView;", "setMSearchEmptyHintText", "(Landroid/widget/TextView;)V", "mSearchEmptyHintImage", "Landroid/widget/ImageView;", "getMSearchEmptyHintImage", "()Landroid/widget/ImageView;", "setMSearchEmptyHintImage", "(Landroid/widget/ImageView;)V", "asView", "setEmptyImageResource", "", "imgResource", "", "setEmptyText", "text", "", "resizeImage", "width", "height", "updateImageVisibility", RemoteMessageConst.Notification.VISIBILITY, "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonSearchEmptyView extends RelativeLayout implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f440330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f440331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f440332c;

    public final ImageView getMSearchEmptyHintImage() {
        return this.f440332c;
    }

    public final TextView getMSearchEmptyHintText() {
        return this.f440331b;
    }

    public final View getMSearchResultEmptyView() {
        return this.f440330a;
    }

    public CommonSearchEmptyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public void setEmptyImageResource(int r100) {
        this.f440332c.setImageResource(r100);
    }

    public void setEmptyText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f440331b.setText(r100);
    }

    public final void setMSearchEmptyHintImage(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440332c = r100;
    }

    public final void setMSearchEmptyHintText(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440331b = r100;
    }

    public final void setMSearchResultEmptyView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440330a = r100;
    }

    public CommonSearchEmptyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.view_search_empty, this, true);
        setGravity(17);
        this.f440330a = findViewById(R.id.search_result_empty);
        this.f440331b = (TextView) findViewById(R.id.search_empty_hint);
        this.f440332c = (ImageView) findViewById(R.id.search_empty_iv);
    }
}
