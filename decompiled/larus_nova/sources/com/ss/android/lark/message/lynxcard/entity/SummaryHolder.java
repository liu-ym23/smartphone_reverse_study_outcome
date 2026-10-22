package com.ss.android.lark.message.lynxcard.entity;

import androidx.collection.LruCache;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(com.ss.android.lark.chat.entity.message.content.a.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/message/lynxcard/entity/SummaryHolder;", "Lcom/ss/android/lark/chat/entity/message/content/ISummaryAPI;", "<init>", "()V", "getSummary", "", "content", "Lcom/ss/android/lark/chat/entity/message/content/CardContent;", "Summary", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummaryHolder implements com.ss.android.lark.chat.entity.message.content.a {
    public static final a Companion = null;
    public static final String TAG = "SummaryHolder";
    private static final LruCache<String, b> dataMap = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f432139b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f432138a, r101.f432138a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f432139b, r101.f432139b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f432138a.hashCode() * 31;
            String r101 = this.f432139b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Summary(digest=" + this.f432138a + ", translateDigest=" + this.f432139b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "digest");
            this.f432138a = r100;
            this.f432139b = r101;
        }
    }

    public SummaryHolder() {
    }

    static {
        Companion = new a();
        dataMap = new LruCache(20);
    }

    public static final /* synthetic */ LruCache access$getDataMap$cp() {
        return dataMap;
    }

    @Override // com.ss.android.lark.chat.entity.message.content.a
    public String getSummary(CardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        String r101 = r100.getMessageId();
        if (r101 == null) goto L5;
        b r102 = dataMap.get(r101);
    L7:
        if (r102 != null) goto L9;
        return "";
    L9:
        if (Intrinsics.areEqual(r100.isTranslate(), Boolean.TRUE) == false) goto L16;
        String r103 = r102.f432139b;
        if (r103 != null) goto L14;
        return "";
    L14:
        return r103;
    L16:
        return r102.f432138a;
    L5:
        r102 = null;
        goto L7
    }
}
