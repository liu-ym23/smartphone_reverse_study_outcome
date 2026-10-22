package com.suite.lark.platform.component.storage.clean;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B;\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/PersistentRequest;", "Res", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "Lcom/suite/lark/platform/component/storage/clean/CleanRequest;", "uniqueName", "", DBDefinition.RETRY_COUNT, "", "cleanResources", "", "whitelistResource", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PersistentRequest<Res extends PersistentResource> extends CleanRequest<Res> {
    public PersistentRequest(String r100, int r101, List<? extends Res> r102, List<? extends Res> r103) {
        Intrinsics.checkNotNullParameter(r100, "uniqueName");
        Intrinsics.checkNotNullParameter(r102, "cleanResources");
        super(r100, r101, r102, r103);
    }

    public /* synthetic */ PersistentRequest(String r100, int r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
