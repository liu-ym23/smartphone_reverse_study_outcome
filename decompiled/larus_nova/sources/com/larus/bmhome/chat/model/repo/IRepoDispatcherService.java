package com.larus.bmhome.chat.model.repo;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\bH¦@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH¦@¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\u0090\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020!0%j\b\u0012\u0004\u0012\u00020!`&2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020!2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010,2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001d0\fH¦@¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/IRepoDispatcherService;", "", "dispatch", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getMessageDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "chatRepo", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "conversationRepo", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "userSettingRepo", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "botRepo", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "clearAllRepo", "", "requireTipOff", "", "reportType", "", "entityId", "", "reasonIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasonDetail", "serverIndex", "conversationId", "reportSource", "batchIds", "", "extra", "", "callback", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRepoDispatcherService {
    Object a(int r100, String r101, ArrayList<Integer> r102, String r103, String r104, String r105, int r106, List<String> r107, Map<String, String> r108, Function1<? super Integer, Unit> r110, Continuation<? super Boolean> r111);

    IBotRepoService b();

    ISettingRepoService c();

    <T> Object d(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101);

    IChatRepoService e();

    IConversationRepoService f();

    ExecutorCoroutineDispatcher g();

    IUserSettingRepoService h();
}
