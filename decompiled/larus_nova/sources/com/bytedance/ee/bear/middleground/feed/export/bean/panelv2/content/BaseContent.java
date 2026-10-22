package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/BaseContent;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/content/IContent;", "<init>", "()V", "quote", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "Lkotlin/collections/ArrayList;", "getQuote", "()Ljava/util/ArrayList;", "setQuote", "(Ljava/util/ArrayList;)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "userId", "getUserId", "setUserId", "title", "getTitle", "()Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", d.f25925o, "(Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;)V", "subTitle", "getSubTitle", "setSubTitle", "equals", "", "other", "", "hashCode", "", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseContent implements IContent {
    private String avatarUrl;
    private String name;
    private ArrayList<TextContext> quote;
    private TextContext subTitle;
    private TextContext title;
    private String userId;

    public BaseContent() {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public int hashCode() {
        ArrayList<TextContext> r100 = this.quote;
        if (r100 == null) goto L5;
        Object[] r101 = r100.toArray();
    L6:
        int r102 = Arrays.hashCode(r101) * 31;
        String r103 = this.avatarUrl;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.userId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        TextContext r113 = this.title;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        TextContext r116 = this.subTitle;
        if (r116 == null) goto L26;
        r104 = r116.hashCode();
    L26:
        return r115 + r104;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<TextContext> getQuote() {
        return this.quote;
    }

    public final TextContext getSubTitle() {
        return this.subTitle;
    }

    public final TextContext getTitle() {
        return this.title;
    }

    public final String getUserId() {
        return this.userId;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BaseContent) == true) goto L8;
        return false;
    L8:
        ArrayList<TextContext> r101 = this.quote;
        Object[] r102 = null;
        if (r101 == null) goto L11;
        Object[] r103 = r101.toArray();
    L12:
        BaseContent r104 = (BaseContent) r100;
        ArrayList<TextContext> r105 = r104.quote;
        if (r105 == null) goto L16;
        r102 = r105.toArray();
    L16:
        if (Arrays.equals(r103, r102) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.avatarUrl, r104.avatarUrl) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.name, r104.name) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.userId, r104.userId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.title, r104.title) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.subTitle, r104.subTitle) == true) goto L33;
        return false;
    L33:
        return true;
    L11:
        r103 = null;
        goto L12
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setQuote(ArrayList<TextContext> r100) {
        this.quote = r100;
    }

    public final void setSubTitle(TextContext r100) {
        this.subTitle = r100;
    }

    public final void setTitle(TextContext r100) {
        this.title = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
