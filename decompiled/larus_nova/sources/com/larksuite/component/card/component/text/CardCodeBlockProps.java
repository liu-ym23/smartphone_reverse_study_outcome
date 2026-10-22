package com.larksuite.component.card.component.text;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/component/text/CardCodeBlockProps;", "", "<init>", "()V", "language", "", "getLanguage", "()Ljava/lang/Integer;", "setLanguage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "contents", "", "Lcom/larksuite/component/card/component/text/CardCodeBlockProps$ContentsDTO;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "wordWrap", "", "getWordWrap", "()Z", "setWordWrap", "(Z)V", "version", "getVersion", "()I", "setVersion", "(I)V", "Companion", "ContentsDTO", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardCodeBlockProps {
    public static final a Companion = null;
    public static final String TAG = "CardCodeBlockProps";

    @SerializedName("contents")
    private List<b> contents;

    @SerializedName("language")
    private Integer language;

    @SerializedName("version")
    private int version;

    @SerializedName("wordWrap")
    private boolean wordWrap;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/text/CardCodeBlockProps$ContentsDTO;", "", "<init>", "()V", "contents", "", "Lcom/larksuite/component/card/component/text/CardCodeBlockProps$ContentsDTO$ContentDTO;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "ContentDTO", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("contents")
        private List<a> contents;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/text/CardCodeBlockProps$ContentsDTO$ContentDTO;", "", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a {

            @SerializedName("content")
            private String content;

            @SerializedName("type")
            private Integer type;

            public a() {
                this.type = 0;
            }

            public final String a() {
                return this.content;
            }

            public final Integer getType() {
                return this.type;
            }

            public final void b(String r100) {
                this.content = r100;
            }

            public final void c(Integer r100) {
                this.type = r100;
            }
        }

        public b() {
        }

        public final List<a> a() {
            return this.contents;
        }

        public final void b(List<a> r100) {
            this.contents = r100;
        }
    }

    static {
        Companion = new a();
    }

    public CardCodeBlockProps() {
    }

    public final List<b> getContents() {
        return this.contents;
    }

    public final Integer getLanguage() {
        return this.language;
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean getWordWrap() {
        return this.wordWrap;
    }

    public final void setContents(List<b> r100) {
        this.contents = r100;
    }

    public final void setLanguage(Integer r100) {
        this.language = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }

    public final void setWordWrap(boolean r100) {
        this.wordWrap = r100;
    }
}
