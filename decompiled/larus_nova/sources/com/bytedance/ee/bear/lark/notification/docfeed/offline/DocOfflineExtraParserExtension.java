package com.bytedance.ee.bear.lark.notification.docfeed.offline;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import dtb.a;
import dtb.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/lark/notification/docfeed/offline/DocOfflineExtraParserExtension;", "Lcom/ss/android/lark/notification/export/offline/IOfflineExtraParserExtension;", "<init>", "()V", "getParserType", "", "getOfflineExtraParser", "Lcom/ss/android/lark/notification/export/offline/IOfflineExtraParser;", "data", "Lcom/ss/android/lark/notification/export/offline/OfflineNotice;", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocOfflineExtraParserExtension implements a {
    public DocOfflineExtraParserExtension() {
    }

    public String getParserType() {
        return "doc";
    }

    public IOfflineExtraParser getOfflineExtraParser(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new DocOfflineExtraParser(r100);
    }
}
