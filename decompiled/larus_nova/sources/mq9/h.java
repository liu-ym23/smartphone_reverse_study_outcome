package mq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JR\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/platform/model/avatar/RecordInfoConfig;", "", "beforeRecordContent", "", "recordContent", "wordList", "", "wordNum", "", "wordType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBeforeRecordContent", "()Ljava/lang/String;", "getRecordContent", "getWordList", "()Ljava/util/List;", "getWordNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWordType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/model/avatar/RecordInfoConfig;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("before_record_content")
    private final String beforeRecordContent;

    @SerializedName("record_content")
    private final String recordContent;

    @SerializedName("word_list")
    private final List<String> wordList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_WORD_NUM)
    private final Integer wordNum;

    @SerializedName("word_type")
    private final Integer wordType;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.beforeRecordContent, r101.beforeRecordContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recordContent, r101.recordContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.wordList, r101.wordList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.wordNum, r101.wordNum) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.wordType, r101.wordType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.beforeRecordContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.recordContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.wordList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.wordNum;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.wordType;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "RecordInfoConfig(beforeRecordContent=" + this.beforeRecordContent + ", recordContent=" + this.recordContent + ", wordList=" + this.wordList + ", wordNum=" + this.wordNum + ", wordType=" + this.wordType + ')';
    }

    public final String a() {
        return this.beforeRecordContent;
    }

    public /* synthetic */ h(int r100) {
        this(null, null, null, 2, 2);
    }

    public h(String r100, String r101, List<String> r102, Integer r103, Integer r104) {
        this.beforeRecordContent = r100;
        this.recordContent = r101;
        this.wordList = r102;
        this.wordNum = r103;
        this.wordType = r104;
    }
}
