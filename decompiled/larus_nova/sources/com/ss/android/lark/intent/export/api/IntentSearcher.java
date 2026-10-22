package com.ss.android.lark.intent.export.api;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J \u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IntentSearcher;", "D", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "searchIntentEntity", "Lkotlin/Result;", "searchContent", "searchIntentEntity-YNEx5aM", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IntentSearcher<D, T extends SearchBaseInfo> {
    /* JADX INFO: renamed from: searchIntentEntity-YNEx5aM, reason: not valid java name */
    Object m8643searchIntentEntityYNEx5aM(D r100, Continuation<? super Result<? extends T>> r101);
}
