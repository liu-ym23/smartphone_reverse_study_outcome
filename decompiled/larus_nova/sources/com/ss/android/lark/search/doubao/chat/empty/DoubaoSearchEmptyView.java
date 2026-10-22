package com.ss.android.lark.search.doubao.chat.empty;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.utils.EmptyViewManager;
import com.ss.android.lark.search.ui.result.SearchResultView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import j4c.r;
import j4c.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0016H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J$\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\u0018H\u0016J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\fH\u0016J\u0012\u0010?\u001a\u00020\u00182\b\b\u0001\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010A\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/empty/DoubaoSearchEmptyView;", "Landroid/widget/RelativeLayout;", "Lcom/ss/android/lark/search/ui/result/view/ISearchResultEmptyView;", "Lcom/ss/android/lark/search/ui/result/view/IColdAndHotEmptyView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "searchResultEmptyView", "Landroid/view/View;", "searchEmptyHintText", "Landroid/widget/TextView;", "searchErrorView", "emptyType", "", "coldAndHotClickListener", "Lcom/ss/android/lark/search/ui/result/utils/EmptyViewManager$IEmptyViewColdAndHotListener;", "makeCenterColdAndHotEmptyMsg", "Lkotlin/Pair;", "", "shouldSetOneThirdPlace", "", "should", "", "setColdAndHotType", "coldAndHotType", "setEmptyViewColdAndHotListener", "emptyViewClickListener", "updateSearchResultViewEmptyView", "query", "addClickableSpan", "", "text", "startIndex", "endIndex", "setOnClickEmptyView", "onClickEmptyView", "Lcom/ss/android/lark/search/ui/result/SearchResultView$IOnClickEmptyView;", "updateKnowledgeStreamInChatInsideButton", "visible", "info", "Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo;", "itemClick", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "updateAnswerInChatInsideButton", "Lcom/ss/android/lark/search/dto/info/AnswerInChatSearchInfo;", "onClickListener", "Landroid/view/View$OnClickListener;", "updateMsgRemindSetting", "setting", "Lcom/ss/android/lark/search/dto/service/MessageRemindSetting;", "messageRemindShowListener", "listener", "Lcom/ss/android/lark/search/ui/result/view/IRemindListener;", "updateChatInsideDefaultView", "type", "updateChatInsideSearchImageFailedView", "updateChatInsideSearchImageEmptyView", "emptyQuery", "asView", "setEmptyImageResource", "imgResource", "setEmptyText", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoubaoSearchEmptyView extends RelativeLayout implements u, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f440057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f440058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f440059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f440060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i4c.a.c f440061e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoSearchEmptyView f440062a;

        public a(DoubaoSearchEmptyView r100) {
            this.f440062a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i4c.a.c r101 = this.f440062a.f440061e;
            if (r101 == null) goto L6;
            r101.onLoadCold();
            return;
        }
    }

    @Override // j4c.u
    public final DoubaoSearchEmptyView asView() {
        return this;
    }

    public void setEmptyImageResource(int r100) {
    }

    @Override // j4c.r
    public void setOnClickEmptyView(SearchResultView.c r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickEmptyView");
    }

    public DoubaoSearchEmptyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // j4c.r
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "query");
        int r111 = this.f440060d;
        boolean r100 = false;
        if (r111 != 4) goto L5;
        this.f440059c.setVisibility(8);
        this.f440058b.setVisibility(0);
        i4c.a.c r112 = this.f440061e;
        String r101 = "";
        if (r112 == null) goto L12;
        String r113 = r112.a();
        if (r113 == null) goto L12;
    L14:
        if (r113.length() != 0) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L35;
        int r103 = StringsKt.indexOf$default(r113, "<b>", 0, false, 6, null);
        if (r103 < 0) goto L22;
        String r114 = r113.substring(0, r103);
    L23:
        int r104 = StringsKt.lastIndexOf$default(r113, "<b>", 0, false, 6, null);
        if (r104 < 0) goto L27;
        r101 = r113.substring(r103 + 3, r104);
    L27:
        if (r114.length() != 0) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == true) goto L32;
    L36:
        Pair r116 = new Pair(r114, r101);
    L38:
        if (r116 == null) goto L40;
        int r105 = ((String) r116.getFirst()).length();
        int r106 = ((String) r116.getSecond()).length() + r105;
        CharSequence r117 = y0.b(((String) r116.getFirst()) + ((String) r116.getSecond()), r105, ((String) r116.getFirst()).length() + ((String) r116.getSecond()).length(), (String) r116.getSecond(), UIHelper.getColor(R.color.lkui_B500));
        Intrinsics.checkNotNull(r117);
        SpannableStringBuilder r107 = new SpannableStringBuilder(r117);
        r107.setSpan(new r3c.a(this), r105, r106, 33);
        this.f440058b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f440058b.setText(r107);
        return;
    L40:
        String r118 = getContext().getResources().getString(R.string.Lark_Search_NoResultsFromPast1YearViewEarlier_EmptyState);
        String r108 = getContext().getResources().getString(R.string.Lark_Search_NoResultsFromPast1YearViewEarlier_Variable);
        int r109 = StringsKt.indexOf$default(r118, "{", 0, false, 6, null);
        int r119 = r108.length() + r109;
        CharSequence r120 = y0.b(UIHelper.mustacheFormat(r118, EmptyViewManager.VIEW_EARLIER, r108), r109, r119, r108, UIHelper.getColor(R.color.lkui_B500));
        Intrinsics.checkNotNull(r120);
        SpannableStringBuilder r121 = new SpannableStringBuilder(r120);
        r121.setSpan(new r3c.a(this), r109, r119, 33);
        this.f440058b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f440058b.setText(r121);
        return;
    L32:
        if (r101.length() != 0) goto L34;
        r100 = true;
    L34:
        if (r100 == false) goto L36;
    L29:
        r115 = false;
        goto L30
    L22:
        r114 = "";
    L35:
        r116 = null;
        goto L38
    L16:
        r102 = false;
    L12:
        r113 = "";
        goto L14
    L5:
        if (r111 == 6) goto L7;
        this.f440059c.setVisibility(8);
        this.f440058b.setVisibility(0);
        this.f440058b.setText(getContext().getResources().getText(R.string.LarkIM_Friend_NoSearchResult_EmptyState));
        return;
    L7:
        this.f440059c.setVisibility(0);
        this.f440058b.setVisibility(8);
        this.f440059c.setOnClickListener(new a(this));
    }

    @Override // j4c.r
    public void setColdAndHotType(int r100) {
        this.f440060d = r100;
    }

    public void setEmptyText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f440058b.setText(r100);
    }

    @Override // j4c.r
    public void setEmptyViewColdAndHotListener(i4c.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "emptyViewClickListener");
        this.f440061e = r100;
    }

    public DoubaoSearchEmptyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.doubao_chat_search_empty, this, true);
        this.f440057a = findViewById(R.id.search_result_empty);
        this.f440058b = (TextView) findViewById(R.id.search_empty_hint);
        this.f440059c = findViewById(R.id.search_result_error);
    }
}
