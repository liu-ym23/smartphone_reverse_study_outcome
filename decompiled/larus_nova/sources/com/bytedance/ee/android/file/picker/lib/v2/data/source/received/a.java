package com.bytedance.ee.android.file.picker.lib.v2.data.source.received;

import android.content.Context;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements um4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReceivedDataSourceV1Impl f206037a;

    /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.data.source.received.a$a, reason: collision with other inner class name */
    public static final class C2965a {
    }

    static {
    }

    @Override // um4.a
    public final Flow<List<FileEntry>> load() {
        return this.f206037a.load();
    }

    @Inject
    public a(@ApplicationContext Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f206037a = new ReceivedDataSourceV1Impl(r100);
    }
}
