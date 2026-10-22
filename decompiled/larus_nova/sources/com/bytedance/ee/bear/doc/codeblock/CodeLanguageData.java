package com.bytedance.ee.bear.doc.codeblock;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "list", "", "", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "toString", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeLanguageData implements NonProguard {
    private List<String> list;
    private String value;

    public CodeLanguageData() {
    }

    public String toString() {
        return "CodeBlockLanguageData(value=" + this.value + ", views=" + this.list + ')';
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setList(List<String> r100) {
        this.list = r100;
    }

    public final void setValue(String r100) {
        this.value = r100;
    }
}
