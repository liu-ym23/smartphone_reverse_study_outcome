package com.larus.bmhome.chat.bean;

import androidx.collection.LruCache;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J&\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecordStreamCache;", "Landroidx/collection/LruCache;", "", "<init>", "()V", "TAG", "append", "", "messageId", "content", "replace", "startIndex", "", "endIndex", DocumentType.DOCX_SYNC_BLOCK_NAME, "key", PickerReporterConstants.KEY.TARGET, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordStreamCache extends LruCache<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecordStreamCache f297434a = null;

    static {
        f297434a = new RecordStreamCache();
    }

    private RecordStreamCache() {
        super(100);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "content");
        String r102 = get(r100);
        if (r102 != null) goto L5;
        String r103 = put(r100, r101);
        return;
    L5:
        String r104 = put(r100, r102 + r101);
    }
}
