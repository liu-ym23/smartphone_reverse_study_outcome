package com.ss.android.ugc.aweme.search.vision.filter;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/filter/PhotoSearchFilterBoard;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterBoard;", "", "l", "Z", "b", "()Z", "setFromPhoto", "(Z)V", "isFromPhoto", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchFilterBoard extends ECSearchFilterBoard {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f453559l;

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard
    public final boolean b() {
        return this.f453559l;
    }

    public PhotoSearchFilterBoard(Context r100) {
        this(r100, null);
    }

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard
    public final void d(float r100) {
        super.d(r100);
    }

    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard
    public void setFromPhoto(boolean r100) {
        this.f453559l = r100;
    }

    public PhotoSearchFilterBoard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f453559l = true;
    }
}
