package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.utils.t2;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements pw8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f305021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f305022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f305023c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/handler/MindMapWidgetHandler$MindMapData;", "", "isPlaceholder", "", "isEmptySearch", "markdownText", "", "url", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarkdownText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/layout/widget/handler/MindMapWidgetHandler$MindMapData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("is_empty_search")
        private final Boolean isEmptySearch;

        @SerializedName("is_placeholder")
        private final Boolean isPlaceholder;

        @SerializedName("markdown_text")
        private final String markdownText;

        @SerializedName("url")
        private final String url;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.isPlaceholder, r101.isPlaceholder) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isEmptySearch, r101.isEmptySearch) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.markdownText, r101.markdownText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.isPlaceholder;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.isEmptySearch;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.markdownText;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.url;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "MindMapData(isPlaceholder=" + this.isPlaceholder + ", isEmptySearch=" + this.isEmptySearch + ", markdownText=" + this.markdownText + ", url=" + this.url + ')';
        }

        public a() {
            Boolean r100 = Boolean.FALSE;
            this.isPlaceholder = r100;
            this.isEmptySearch = r100;
            this.markdownText = null;
            this.url = null;
        }

        public final String a() {
            return this.markdownText;
        }

        public final String b() {
            return this.url;
        }

        public final Boolean c() {
            return this.isPlaceholder;
        }
    }

    public static final class b implements pw8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f305024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f305025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HtmlBlock f305026c;

        @Override // pw8.a
        public final void a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
        }

        @Override // pw8.a
        public final void b(int r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r101, "currentViewGroup");
            r101.removeViewAt(r101.getChildCount() - 1);
            pw8.a r102 = pw8.b.a.a(this.f305024a, this.f305025b, 0, this.f305026c, Boolean.TRUE);
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }

        public b(f r100, Context r101, HtmlBlock r102) {
            this.f305024a = r100;
            this.f305025b = r101;
            this.f305026c = r102;
        }
    }

    @Override // pw8.b
    public final int priority() {
        return 12;
    }

    public f(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f305021a = r100;
        this.f305022b = "MindMapWidgetHandler";
        this.f305023c = new Gson();
    }

    @Override // pw8.b
    public final boolean c(uvc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if ((r100 instanceof HtmlBlock) == false) goto L9;
        int r101 = vh8.a.f554987a;
        HtmlBlock r102 = (HtmlBlock) r100;
        if (vh8.a.b(r102.f525768h) == false) goto L9;
        int r103 = t2.f315114a;
        if (Intrinsics.areEqual(t2.b(r102.f525768h), "mind-map") == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // pw8.b
    public final pw8.a a(Context r100, int r101, uvc.b r102, Boolean r103, lw8.h r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "node");
        a r105 = null;
        if ((r102 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r106 = (HtmlBlock) r102;
    L6:
        if (r106 == null) goto L17;
        int r107 = t2.f315114a;
        String r108 = t2.a(this.f305021a.getMessageId(), ((HtmlBlock) r102).f525768h);
        if (r108 == null) goto L17;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L11
        r105 = (a) this.f305023c.fromJson(r108, a.class);     // Catch: Throwable -> L11
    L13:
        if (r105 == null) goto L17;
        FLogger.f375446a.d(this.f305022b, "[biz_deep_search] mindMapData.isPlaceholder == " + Intrinsics.areEqual(r105.c(), Boolean.TRUE));
        return new i(r100, r105, this);
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
    L17:
        return new j(r100, this);
    L5:
        r106 = null;
        goto L6
    }

    @Override // pw8.b
    public final pw8.a b(Context r100, int r101, int r102, ViewGroup r103, uvc.b r104, Boolean r105, lw8.h r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r104, "node");
        if ((r104 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r107 = (HtmlBlock) r104;
    L6:
        if (r107 != null) goto L8;
    L11:
        return null;
    L8:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L11;
        return new b(this, r100, r107);
    L5:
        r107 = null;
        goto L6
    }
}
