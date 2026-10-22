package com.ss.android.ugc.aweme.helper.imagex;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformRule;", "Ljava/io/Serializable;", "()V", "fileFormatPattern", "", "getFileFormatPattern", "()Ljava/lang/String;", "setFileFormatPattern", "(Ljava/lang/String;)V", "fileFormats", "", "getFileFormats", "()Ljava/util/List;", "setFileFormats", "(Ljava/util/List;)V", "pattern", "getPattern", "setPattern", "templateFormats", "getTemplateFormats", "setTemplateFormats", "couldTransformFileFormat", "", "couldTransformTemplate", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchImageUrlTransformRule implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("file_format_pattern")
    private String fileFormatPattern;

    @SerializedName("file_formats")
    private List<String> fileFormats;

    @SerializedName("pattern")
    private String pattern;

    @SerializedName("template_formats")
    private List<String> templateFormats;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/imagex/ECSearchImageUrlTransformRule$Companion;", "", "()V", "serialVersionUID", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ECSearchImageUrlTransformRule() {
    }

    public final boolean couldTransformFileFormat() {
        String r100 = this.fileFormatPattern;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L20;
        List<String> r102 = this.fileFormats;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean couldTransformTemplate() {
        String r100 = this.pattern;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L20;
        List<String> r102 = this.templateFormats;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r102.isEmpty() == true) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String getFileFormatPattern() {
        return this.fileFormatPattern;
    }

    public final List<String> getFileFormats() {
        return this.fileFormats;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final List<String> getTemplateFormats() {
        return this.templateFormats;
    }

    public final void setFileFormatPattern(String r100) {
        this.fileFormatPattern = r100;
    }

    public final void setFileFormats(List<String> r100) {
        this.fileFormats = r100;
    }

    public final void setPattern(String r100) {
        this.pattern = r100;
    }

    public final void setTemplateFormats(List<String> r100) {
        this.templateFormats = r100;
    }
}
