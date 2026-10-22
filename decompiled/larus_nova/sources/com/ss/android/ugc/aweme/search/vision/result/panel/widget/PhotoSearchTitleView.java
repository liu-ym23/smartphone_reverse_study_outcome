package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.ISearchBackListener;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.aweme.search.vision.util.PhotoSearchUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchTitleView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/search/common/ISearchBackListener;", "backListener", "", "setSearchBackListener", "Landroid/view/View;", "getIndicatorBar", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f453758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f453759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ISearchBackListener f453760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f453761d;

    public PhotoSearchTitleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoSearchTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View getIndicatorBar() {
        return this.f453761d;
    }

    public final void a(PhotoEnterModel r100) {
        PhotoSearchUtils.f454046a.getClass();
        if (r100 == null) goto L8;
        String r101 = r100.getClientParams();
        if (r101 == null) goto L8;
        int r102 = new JSONObject(r101).optInt("product_detail_auto_show_style");     // Catch: Exception -> L38
    L10:
        if (r102 != 1) goto L12;
        ImageView r103 = this.f453759b;
        if (r103 == null) goto L23;
        r103.setVisibility(0);
    L23:
        View r104 = this.f453761d;
        if (r104 == null) goto L26;
        r104.setVisibility(4);
    L26:
        TextView r105 = this.f453758a;
        if (r105 == null) goto L43;
        PhotoSearchUtils.f454046a.getClass();
        if (r100 == null) goto L34;
        String r106 = r100.getClientParams();
        if (r106 == null) goto L34;
        String r107 = new JSONObject(r106).optString("product_detail_auto_show_title");     // Catch: Exception -> L37
    L35:
        r105.setText(r107);
        return;
    L34:
        r107 = "";
        goto L35
    L43:
        return;
    L12:
        if (r102 != 2) goto L26;
        View r108 = this.f453761d;
        if (r108 == null) goto L17;
        r108.setVisibility(0);
    L17:
        ImageView r109 = this.f453759b;
        if (r109 == null) goto L26;
        r109.setVisibility(4);
    L8:
        r102 = 0;
        goto L10
    }

    public final void setSearchBackListener(ISearchBackListener r100) {
        this.f453760c = r100;
    }

    public PhotoSearchTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.photo_search_title_view, this);
        this.f453758a = (TextView) findViewById(R.id.photo_search_title_text);
        ImageView r103 = (ImageView) findViewById(R.id.photo_search_title_close);
        this.f453759b = r103;
        this.f453761d = findViewById(R.id.photo_search_indicator_bar);
        if (r103 == null) goto L6;
        r103.setOnClickListener(new AnonymousClass1(this));
        return;
    }

    public /* synthetic */ PhotoSearchTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
