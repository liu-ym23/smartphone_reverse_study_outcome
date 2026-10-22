package com.bytedance.kmp.gamecp.base.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/message/model/d;", "Lvh7/c;", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "()V", "title", "getContent", "setContent", "getContent$annotations", "content", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getHighlightWords", "()Ljava/util/List;", "getHighlightWords$annotations", "highlightWords", "getButtonText", "setButtonText", "getButtonText$annotations", "buttonText", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "button_text")
    String getButtonText();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "highlight_words")
    List<String> getHighlightWords();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "button_text#setter")
    void setButtonText(String r100);

    @FieldName(name = "content#setter")
    void setContent(String r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);
}
