package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageData;", "", "()V", "list", "", "", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeLanguageData {
    private List<String> list;
    private String value;

    public String toString() {
        return "CodeBlockLanguageData(value=" + this.value + ", views=" + this.list + ')';
    }

    public CodeLanguageData() {
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setList(List<String> r1) {
        this.list = r1;
    }

    public final void setValue(String r1) {
        this.value = r1;
    }
}
