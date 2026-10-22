package com.larus.im.internal.core.conversation.group;

import android.os.SystemClock;
import com.larus.im.bean.conversation.ConversationArchiveFilter;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.core.conversation.converter.ConversationConverterKt;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.delegate.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import wc9.l;
import wc9.n;

/* JADX INFO: loaded from: classes29.dex */
public final class LoadLocalConversationsProcessor extends IMActionProcessor<n, wc9.i> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f347584f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f347586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f347587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f347588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f347589e;

    public static abstract class PagingQueryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f347590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f347591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f347592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConversationArchiveFilter f347593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f347594e;

        public abstract PagingQueryState a(Integer r100);

        public abstract Object b(Continuation<? super List<ConversationEntity>> r100);

        public final Object query(Continuation<? super List<ConversationEntity>> r100) {
            if ((r100 instanceof LoadLocalConversationsProcessor$PagingQueryState$query$1) == false) goto L7;
            LoadLocalConversationsProcessor$PagingQueryState$query$1 r101 = (LoadLocalConversationsProcessor$PagingQueryState$query$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            long r106 = r101.J$0;
            ResultKt.throwOnFailure(r103);
        L18:
            List r107 = (List) r103;
            this.f347594e = SystemClock.elapsedRealtime() - r106;
            return r107;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            long r108 = SystemClock.elapsedRealtime();
            r101.J$0 = r108;
            r101.label = 1;
            r103 = b(r101);
            if (r103 != r104) goto L17;
            return r104;
        L17:
            r106 = r108;
        L7:
            r101 = new LoadLocalConversationsProcessor$PagingQueryState$query$1(this, r100);
            goto L8
        }

        public PagingQueryState(int r100, int r101, long r102, ConversationArchiveFilter r103) {
            Intrinsics.checkNotNullParameter(r103, "archiveFilter");
            this.f347590a = r100;
            this.f347591b = r101;
            this.f347592c = r102;
            this.f347593d = r103;
        }
    }

    public static final class QueryFirstState extends PagingQueryState {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<ConversationEntity> f347595f;

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final PagingQueryState a(Integer r110) {
            List<ConversationEntity> r100 = this.f347595f;
            if (r100.size() < this.f347591b) goto L5;
            List<ConversationEntity> r101 = r100;
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L7:
            boolean r104 = false;
            if (r103.hasNext() == false) goto L19;
            Object r105 = r103.next();
            ConversationEntity r106 = (ConversationEntity) r105;
            if (r106.getBotType() == 1) goto L17;
            Integer r107 = r106.getPinned();
            if (r107 != null) goto L15;
        L16:
            r104 = true;
            goto L17
        L15:
            if (r107.intValue() != 1) goto L16;
        L17:
            if (r104 == false) goto L7;
            r102.add(r105);
            goto L7
        L19:
            Iterator r108 = r102.iterator();
            Long r109 = null;
            long r111 = Long.MAX_VALUE;
            if (r108.hasNext() == true) goto L22;
            Long r112 = null;
        L36:
            Long r113 = r112;
            if (r113 == null) goto L39;
            long r114 = r113.longValue();
            r104 = true;
        L75:
            if (r104 == false) goto L82;
            int r115 = this.f347590a + 1;
            if (r110 == null) goto L79;
            int r116 = r110.intValue();
        L81:
            return new QueryUnPinState(r115, r116, r114, this.f347593d);
        L79:
            r116 = this.f347591b;
            goto L81
        L82:
            int r117 = this.f347590a + 1;
            if (r110 == null) goto L85;
            int r118 = r110.intValue();
        L87:
            return new QueryPinState(r117, r118, r114, this.f347593d);
        L85:
            r118 = this.f347591b;
            goto L87
        L39:
            ArrayList r119 = new ArrayList();
            Iterator<T> r120 = r101.iterator();
        L41:
            if (r120.hasNext() == false) goto L53;
            Object r121 = r120.next();
            ConversationEntity r122 = (ConversationEntity) r121;
            if (r122.getBotType() == 1) goto L50;
            Integer r123 = r122.getPinned();
            if (r123 == null) goto L50;
            if (r123.intValue() != 1) goto L50;
            boolean r124 = true;
        L51:
            if (r124 == false) goto L41;
            r119.add(r121);
        L50:
            r124 = false;
            goto L51
        L53:
            Iterator r125 = r119.iterator();
            if (r125.hasNext() == false) goto L71;
            Long r126 = ((ConversationEntity) r125.next()).getVersion();
            if (r126 == null) goto L59;
            long r127 = r126.longValue();
        L60:
            Long r128 = Long.valueOf(r127);
        L61:
            r109 = r128;
        L63:
            if (r125.hasNext() == false) goto L71;
            Long r129 = ((ConversationEntity) r125.next()).getVersion();
            if (r129 == null) goto L67;
            long r130 = r129.longValue();
        L68:
            r128 = Long.valueOf(r130);
            if (r109.compareTo(r128) <= 0) goto L63;
        L67:
            r130 = Long.MAX_VALUE;
            goto L68
        L59:
            r127 = Long.MAX_VALUE;
        L71:
            Long r131 = r109;
            if (r131 == null) goto L74;
            r111 = r131.longValue();
        L74:
            r114 = r111;
            goto L75
        L22:
            Long r132 = ((ConversationEntity) r108.next()).getVersion();
            if (r132 == null) goto L25;
            long r133 = r132.longValue();
        L26:
            r112 = Long.valueOf(r133);
        L28:
            if (r108.hasNext() == false) goto L36;
            Long r134 = ((ConversationEntity) r108.next()).getVersion();
            if (r134 == null) goto L32;
            long r135 = r134.longValue();
        L33:
            Long r136 = Long.valueOf(r135);
            if (r112.compareTo(r136) <= 0) goto L28;
            r112 = r136;
            goto L28
        L32:
            r135 = Long.MAX_VALUE;
            goto L33
        L25:
            r133 = Long.MAX_VALUE;
            goto L26
        L5:
            return new b(this.f347590a);
        }

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final Object b(Continuation<? super List<ConversationEntity>> r100) {
            if ((r100 instanceof LoadLocalConversationsProcessor$QueryFirstState$queryLogic$1) == false) goto L7;
            LoadLocalConversationsProcessor$QueryFirstState$queryLogic$1 r101 = (LoadLocalConversationsProcessor$QueryFirstState$queryLogic$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L16;
            if (r105 == 1) goto L15;
            if (r105 != 2) goto L14;
            ResultKt.throwOnFailure(r103);
        L25:
            List<ConversationEntity> r106 = (List) r103;
        L26:
            this.f347595f = r106;
            return r106;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r103);
        L21:
            r106 = (List) r103;
            goto L26
        L16:
            ResultKt.throwOnFailure(r103);
            if (this.f347593d != ConversationArchiveFilter.ALL) goto L22;
            be9.b r107 = ae9.b.a();
            int r108 = this.f347591b;
            r101.label = 1;
            r103 = r107.t(r108, r101);
            if (r103 != r104) goto L21;
            return r104;
        L22:
            be9.b r109 = ae9.b.a();
            int r110 = this.f347591b;
            int r111 = this.f347593d.getValue();
            r101.label = 2;
            r103 = r109.v(r110, r111, r101);
            if (r103 != r104) goto L25;
            return r104;
        L7:
            r101 = new LoadLocalConversationsProcessor$QueryFirstState$queryLogic$1(this, r100);
            goto L8
        }

        public QueryFirstState(int r100, ConversationArchiveFilter r101) {
            Intrinsics.checkNotNullParameter(r101, "archiveFilter");
            super(0, r100, Long.MAX_VALUE, r101);
            this.f347595f = CollectionsKt.emptyList();
        }
    }

    public static final class QueryPinState extends PagingQueryState {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f347596f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f347597g;

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final PagingQueryState a(Integer r110) {
            int r100 = this.f347596f;
            if (r100 == 0) goto L5;
            int r101 = this.f347591b;
            if (r100 >= r101) goto L13;
            int r102 = this.f347590a + 1;
            if (r110 == null) goto L12;
            r101 = r110.intValue();
        L12:
            return new QueryUnPinState(r102, r101, this.f347593d);
        L13:
            int r103 = this.f347590a + 1;
            if (r110 == null) goto L17;
            r101 = r110.intValue();
        L17:
            return new QueryPinState(r103, r101, this.f347597g, this.f347593d);
        L5:
            return new QueryUnPinState(this.f347590a, this.f347591b, this.f347593d);
        }

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final Object b(Continuation<? super List<ConversationEntity>> r100) {
            if ((r100 instanceof LoadLocalConversationsProcessor$QueryPinState$queryLogic$1) == false) goto L7;
            LoadLocalConversationsProcessor$QueryPinState$queryLogic$1 r101 = (LoadLocalConversationsProcessor$QueryPinState$queryLogic$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            LoadLocalConversationsProcessor$QueryPinState$queryLogic$1 r103 = r101;
            Object r104 = r103.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r103.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L25:
            List r107 = (List) r104;
        L26:
            this.f347596f = r107.size();
            ArrayList r108 = new ArrayList();
            Iterator r109 = r107.iterator();
        L28:
            if (r109.hasNext() == false) goto L32;
            Long r110 = ((ConversationEntity) r109.next()).getVersion();
            if (r110 == null) goto L28;
            r108.add(r110);
            goto L28
        L32:
            Long r111 = (Long) CollectionsKt.minOrNull(r108);
            if (r111 == null) goto L35;
            long r112 = r111.longValue();
        L36:
            this.f347597g = r112;
            return r107;
        L35:
            r112 = 0;
            goto L36
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
        L21:
            r107 = (List) r104;
            goto L26
        L16:
            ResultKt.throwOnFailure(r104);
            if (this.f347593d != ConversationArchiveFilter.ALL) goto L22;
            be9.b r113 = ae9.b.a();
            int r114 = this.f347591b;
            long r115 = this.f347592c;
            r103.label = 1;
            r104 = r113.F(r114, r115, r103);
            if (r104 != r105) goto L21;
            return r105;
        L22:
            be9.b r116 = ae9.b.a();
            int r117 = this.f347591b;
            long r118 = this.f347592c;
            int r119 = this.f347593d.getValue();
            r103.label = 2;
            r104 = r116.p(r117, r118, r119, r103);
            if (r104 != r105) goto L25;
            return r105;
        L7:
            r101 = new LoadLocalConversationsProcessor$QueryPinState$queryLogic$1(this, r100);
            goto L8
        }

        public QueryPinState(int r100, int r101, long r102, ConversationArchiveFilter r103) {
            Intrinsics.checkNotNullParameter(r103, "archiveFilter");
            super(r100, r101, r102, r103);
        }
    }

    public static final class QueryUnPinState extends PagingQueryState {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f347598f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f347599g;

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final PagingQueryState a(Integer r100) {
            int r101 = this.f347598f;
            int r102 = this.f347591b;
            if (r101 < r102) goto L5;
            int r103 = this.f347590a + 1;
            if (r100 == null) goto L10;
            r102 = r100.intValue();
        L10:
            return new QueryUnPinState(r103, r102, this.f347599g, this.f347593d);
        L5:
            return new b(this.f347590a);
        }

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final Object b(Continuation<? super List<ConversationEntity>> r100) {
            if ((r100 instanceof LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1) == false) goto L7;
            LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1 r101 = (LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1 r103 = r101;
            Object r104 = r103.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r103.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L25:
            List r107 = (List) r104;
        L26:
            this.f347598f = r107.size();
            ArrayList r108 = new ArrayList();
            Iterator r109 = r107.iterator();
        L28:
            if (r109.hasNext() == false) goto L32;
            Long r110 = ((ConversationEntity) r109.next()).getVersion();
            if (r110 == null) goto L28;
            r108.add(r110);
            goto L28
        L32:
            Long r111 = (Long) CollectionsKt.minOrNull(r108);
            if (r111 == null) goto L35;
            long r112 = r111.longValue();
        L36:
            this.f347599g = r112;
            return r107;
        L35:
            r112 = 0;
            goto L36
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
        L21:
            r107 = (List) r104;
            goto L26
        L16:
            ResultKt.throwOnFailure(r104);
            if (this.f347593d != ConversationArchiveFilter.ALL) goto L22;
            be9.b r113 = ae9.b.a();
            int r114 = this.f347591b;
            long r115 = this.f347592c;
            r103.label = 1;
            r104 = r113.G(r114, r115, r103);
            if (r104 != r105) goto L21;
            return r105;
        L22:
            be9.b r116 = ae9.b.a();
            int r117 = this.f347591b;
            long r118 = this.f347592c;
            int r119 = this.f347593d.getValue();
            r103.label = 2;
            r104 = r116.E(r117, r118, r119, r103);
            if (r104 != r105) goto L25;
            return r105;
        L7:
            r101 = new LoadLocalConversationsProcessor$QueryUnPinState$queryLogic$1(this, r100);
            goto L8
        }

        public QueryUnPinState(int r100, int r101, ConversationArchiveFilter r102) {
            Intrinsics.checkNotNullParameter(r102, "archiveFilter");
            super(r100, r101, Long.MAX_VALUE, r102);
        }

        public QueryUnPinState(int r100, int r101, long r102, ConversationArchiveFilter r103) {
            Intrinsics.checkNotNullParameter(r103, "archiveFilter");
            super(r100, r101, r102, r103);
        }
    }

    public static final class a {
    }

    public static final class b extends PagingQueryState {
        public b(int r100) {
            super(r100, 0, 0, ConversationArchiveFilter.ALL);
        }

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final PagingQueryState a(Integer r100) {
            return new b(this.f347590a);
        }

        @Override // com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor.PagingQueryState
        public final Object b(Continuation<? super List<ConversationEntity>> r100) {
            return CollectionsKt.emptyList();
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347600a = null;

        static {
            int[] r100 = new int[ConversationArchiveFilter.values().length];
            r100[ConversationArchiveFilter.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ConversationArchiveFilter.INCLUDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ConversationArchiveFilter.EXCLUDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f347600a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$process$1", f = "LoadLocalConversationsProcessor.kt", i = {}, l = {53, 55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LoadLocalConversationsProcessor this$0;

        public AnonymousClass1(LoadLocalConversationsProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L13;
            if (r102 == 1) goto L9;
            if (r102 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L11
        L28:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r100);
            if (y0.l() == false) goto L17;
            LoadLocalConversationsProcessor r103 = this.this$0;     // Catch: Exception -> L11
            int r104 = LoadLocalConversationsProcessor.f347584f;     // Catch: Exception -> L11
            ConversationArchiveFilter r105 = r103.getRequest().f559254e;     // Catch: Exception -> L11
        L18:
            LoadLocalConversationsProcessor r106 = this.this$0;     // Catch: Exception -> L11
            int r107 = LoadLocalConversationsProcessor.f347584f;     // Catch: Exception -> L11
            if (r106.getRequest().f559251b == false) goto L23;
            LoadLocalConversationsProcessor r108 = this.this$0;     // Catch: Exception -> L11
            this.label = 1;     // Catch: Exception -> L11
            if (LoadLocalConversationsProcessor.d(r108, r105, this) != r101) goto L28;
            return r101;
        L23:
            LoadLocalConversationsProcessor r109 = this.this$0;     // Catch: Exception -> L11
            this.label = 2;     // Catch: Exception -> L11
            if (LoadLocalConversationsProcessor.c(r109, r105, this) != r101) goto L28;
            return r101;
        L17:
            r105 = ConversationArchiveFilter.ALL;     // Catch: Exception -> L11
        L11:
            e = move-exception;
            LoadLocalConversationsProcessor r110 = this.this$0;
            IMError r111 = new IMError(-1, "loadLocalConversations failed.", e, null, 8, null);
            int r112 = LoadLocalConversationsProcessor.f347584f;
            r110.onFailure(r111);
            goto L28
        }
    }

    static {
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        this.f347586b = SystemClock.elapsedRealtime();
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347585a;
    }

    public LoadLocalConversationsProcessor(n r100, IIMCallback<wc9.i> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super(r100, r101);
        this.f347585a = "LoadLocalConversationsProcessor";
        this.f347586b = SystemClock.elapsedRealtime();
        this.f347587c = new ArrayList();
        this.f347588d = new ArrayList();
        this.f347589e = new ArrayList();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bd -> B:31:0x00c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x017a -> B:59:0x017e). Please report as a decompilation issue!!! */
    public final Object f(Set<String> r110, Continuation<? super Map<String, Message>> r111) {
        if ((r111 instanceof LoadLocalConversationsProcessor$findBriefMessage$1) == false) goto L7;
        LoadLocalConversationsProcessor$findBriefMessage$1 r100 = (LoadLocalConversationsProcessor$findBriefMessage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        Object r113 = r100.L$3;
        Map r104 = (Map) r100.L$2;
        Iterator r105 = (Iterator) r100.L$1;
        Map r106 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L59:
        r104.put(r113, (Message) r112);
        r104 = r106;
    L54:
        if (r105.hasNext() == false) goto L60;
        Map.Entry r114 = (Map.Entry) r105.next();
        Object r115 = r114.getKey();
        MessageEntity r116 = (MessageEntity) r114.getValue();
        r100.L$0 = r104;
        r100.L$1 = r105;
        r100.L$2 = r104;
        r100.L$3 = r115;
        r100.label = 3;
        Object r117 = MessageEntityConverterKt.a(r116, r100);
        if (r117 != r102) goto L58;
        return r102;
    L58:
        r106 = r104;
        r112 = r117;
        r113 = r115;
        goto L59
    L60:
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        List r118 = (List) r100.L$2;
        List r107 = (List) r100.L$1;
        Set<String> r108 = (Set) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L39:
        Boxing.boxBoolean(r118.addAll((Collection) r112));
        List r119 = r107;
        r110 = r108;
    L41:
        if (r110.isEmpty() == true) goto L62;
        if (r119.isEmpty() == true) goto L62;
        List r120 = r119;
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r120, 10)), 16));
        Iterator r121 = r120.iterator();
    L47:
        if (r121.hasNext() == false) goto L52;
        Object r122 = r121.next();
        String r123 = ((MessageEntity) r122).getConversationId();
        if (r123 != null) goto L51;
        r123 = "";
    L51:
        r109.put(r123, r122);
        goto L47
    L52:
        LinkedHashMap r124 = new LinkedHashMap(MapsKt.mapCapacity(r109.size()));
        Iterator r125 = r109.entrySet().iterator();
        r104 = r124;
        r105 = r125;
    L62:
        return MapsKt.emptyMap();
    L17:
        int r126 = r100.I$2;
        int r127 = r100.I$1;
        int r128 = r100.I$0;
        List r129 = (List) r100.L$2;
        List r130 = (List) r100.L$1;
        Set<String> r131 = (Set) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L31:
        r129.addAll((Collection) r112);
        if (r126 == r128) goto L34;
        r126 = r126 + 1;
        r129 = r130;
        Set<String> r132 = r131;
    L23:
        int r133 = 400 * r126;
        if (r126 != r128) goto L26;
        int r134 = r127;
    L27:
        be9.d r135 = ae9.e.a();
        List r136 = CollectionsKt.toList(r132);
        List<String> r137 = r136.subList(r133, r134 + r133);
        r100.L$0 = r132;
        r100.L$1 = r129;
        r100.L$2 = r129;
        r100.I$0 = r128;
        r100.I$1 = r127;
        r100.I$2 = r126;
        r100.label = 1;
        Object r138 = r135.b(r137, r100);
        if (r138 != r102) goto L30;
        return r102;
    L30:
        r131 = r132;
        r112 = r138;
        r130 = r129;
        goto L31
    L26:
        r134 = 400;
        goto L27
    L34:
        r119 = r130;
        r110 = r131;
        goto L41
    L18:
        ResultKt.throwOnFailure(r112);
        r119 = new ArrayList();
        if (r110.size() <= 400) goto L35;
        int r139 = r110.size() / 400;
        int r140 = r110.size() % 400;
        if (r139 < 0) goto L41;
        r129 = r119;
        r132 = r110;
        r126 = 0;
        r128 = r139;
        r127 = r140;
        goto L23
    L35:
        be9.d r141 = ae9.e.a();
        List<String> r142 = CollectionsKt.toList(r110);
        r100.L$0 = r110;
        r100.L$1 = r119;
        r100.L$2 = r119;
        r100.label = 2;
        Object r143 = r141.b(r142, r100);
        if (r143 != r102) goto L38;
        return r102;
    L38:
        r108 = r110;
        r118 = r119;
        r112 = r143;
        r107 = r118;
    L7:
        r100 = new LoadLocalConversationsProcessor$findBriefMessage$1(this, r111);
        goto L8
    }

    public static final Object c(LoadLocalConversationsProcessor r210, ConversationArchiveFilter r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof LoadLocalConversationsProcessor$loadAllConversation$1) == false) goto L7;
        LoadLocalConversationsProcessor$loadAllConversation$1 r100 = (LoadLocalConversationsProcessor$loadAllConversation$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        LoadLocalConversationsProcessor$loadAllConversation$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Ref.LongRef r106 = (Ref.LongRef) r102.L$1;
        List r107 = (List) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        long r108 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r210.f347586b;
        int r109 = com.larus.im.internal.tracking.h.f350320a;
        long r110 = r106.element;
        int r111 = r107.size();
        com.larus.im.internal.tracking.h.a(null, Boxing.boxBoolean(false), null, Boxing.boxLong(r108), null, null, Boxing.boxLong(r110), null, null, Boxing.boxInt(r111));
        r210.onSuccess(new wc9.i(r107, false, 0, true));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ArrayList r112 = new ArrayList();
        Ref.LongRef r113 = new Ref.LongRef();
        LoadLocalConversationsProcessor$loadAllConversation$2 r114 = new LoadLocalConversationsProcessor$loadAllConversation$2(r211, r210, r113, r112, null);
        r102.L$0 = r112;
        r102.L$1 = r113;
        r102.label = 1;
        if (OmniDatabaseExtKt.e(r114, r102) == r104) goto L20;
        r107 = r112;
        r106 = r113;
        goto L18
    L20:
        return r104;
    L7:
        r100 = new LoadLocalConversationsProcessor$loadAllConversation$1(r210, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [T, com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$PagingQueryState] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$QueryFirstState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00af -> B:33:0x00b3). Please report as a decompilation issue!!! */
    public static final Object d(LoadLocalConversationsProcessor r210, ConversationArchiveFilter r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof LoadLocalConversationsProcessor$loadConversationV2$1) == false) goto L7;
        LoadLocalConversationsProcessor$loadConversationV2$1 r100 = (LoadLocalConversationsProcessor$loadConversationV2$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        LoadLocalConversationsProcessor r102 = r210;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L33:
        wc9.i r107 = (wc9.i) r103;
    L34:
        ((ArrayList) r102.f347587c).add(Boxing.boxLong(SystemClock.elapsedRealtime()));
        List<Integer> r108 = r102.f347589e;
        if (r107 == null) goto L39;
        List<l> r109 = r107.f559237a;
        if (r109 == null) goto L39;
        int r110 = r109.size();
    L40:
        ((ArrayList) r108).add(Boxing.boxInt(r110));
        if (r107 == null) goto L43;
        r102.onSuccess(r107);
    L44:
        ((ArrayList) r102.f347588d).add(Boxing.boxLong(((PagingQueryState) r106.element).f347594e));
        r106.element = ((PagingQueryState) r106.element).a(Boxing.boxInt(r102.getRequest().f559253d));
    L19:
        T r111 = r106.element;
        if ((r111 instanceof b) == true) goto L46;
        if ((r111 instanceof QueryFirstState) == false) goto L27;
        LoadLocalConversationsProcessor$loadConversationV2$pagingData$1 r112 = new LoadLocalConversationsProcessor$loadConversationV2$pagingData$1(r106, r102, null);
        r100.L$0 = r106;
        r100.label = 1;
        Object r113 = OmniDatabaseExtKt.e(r112, r100);
        if (r113 == r104) goto L58;
        r107 = (wc9.i) r113;
        goto L34
    L58:
        return r104;
    L27:
        LoadLocalConversationsProcessor$loadConversationV2$pagingData$2 r114 = new LoadLocalConversationsProcessor$loadConversationV2$pagingData$2(r106, null);
        r100.L$0 = r106;
        r100.label = 2;
        r103 = OmniDatabaseExtKt.e(r114, r100);
        if (r103 == r104) goto L59;
    L30:
        int r115 = ((PagingQueryState) r106.element).f347590a;
        r100.L$0 = r106;
        r100.label = 3;
        r103 = r102.g((List) r103, r115, r100);
        if (r103 != r104) goto L33;
        return r104;
    L59:
        return r104;
    L46:
        if (((ArrayList) r102.f347587c).isEmpty() == false) goto L48;
    L55:
        int r116 = wc9.i.f559236e;
        r102.onSuccess(new wc9.i(null, true, ((PagingQueryState) r106.element).f347590a, true));
        return Unit.INSTANCE;
    L48:
        if (((ArrayList) r102.f347588d).isEmpty() == true) goto L55;
        long r117 = ((Number) CollectionsKt.first(r102.f347587c)).longValue() - r102.f347586b;
        long r118 = ((Number) CollectionsKt.last(r102.f347587c)).longValue() - r102.f347586b;
        int r119 = ((ArrayList) r102.f347587c).size();
        if (r119 <= 0) goto L53;
        Long r120 = Long.valueOf(r118 / ((long) r119));
    L54:
        int r121 = com.larus.im.internal.tracking.h.f350320a;
        com.larus.im.internal.tracking.h.a(Long.valueOf(r117), Boolean.TRUE, Integer.valueOf(((ArrayList) r102.f347587c).size()), Long.valueOf(r118), r120, (Long) CollectionsKt.firstOrNull(r102.f347588d), Long.valueOf(CollectionsKt.sumOfLong(r102.f347588d)), Long.valueOf(MathKt.roundToLong(CollectionsKt.averageOfLong(r102.f347588d))), (Integer) CollectionsKt.firstOrNull(r102.f347589e), Integer.valueOf(CollectionsKt.sumOfInt(r102.f347589e)));
        goto L55
    L53:
        r120 = null;
        goto L54
    L43:
        com.larus.im.internal.delegate.a.f348188b.i(r102.f347585a, "query paging empty, index: " + ((PagingQueryState) r106.element).f347590a + ", state: " + Reflection.getOrCreateKotlinClass(r106.element.getClass()).getSimpleName());
    L39:
        r110 = 0;
        goto L40
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r106 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r103);
        goto L30
    L17:
        r106 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r103);
        r107 = (wc9.i) r103;
        goto L34
    L18:
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r122 = new Ref.ObjectRef();
        r122.element = new QueryFirstState(r210.getRequest().f559252c, r211);
        r106 = r122;
    L7:
        r102 = r210;
        r100 = new LoadLocalConversationsProcessor$loadConversationV2$1(r102, r212);
        goto L8
    }

    public final Object e(List<ConversationEntity> r100, List<l> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof LoadLocalConversationsProcessor$associateBriefMessage$1) == false) goto L7;
        LoadLocalConversationsProcessor$associateBriefMessage$1 r103 = (LoadLocalConversationsProcessor$associateBriefMessage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (List) r103.L$1;
        r100 = (List) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L25:
        Map r108 = (Map) r105;
        Iterator<ConversationEntity> r109 = r100.iterator();
    L27:
        if (r109.hasNext() == false) goto L40;
        ConversationEntity r110 = r109.next();
        String r111 = r110.getConversationId();
        if (StringsKt.isBlank(r111) == true) goto L30;
        Message r112 = (Message) r108.get(r111);
        if (r112 == null) goto L33;
        r101.add(new l(ConversationConverterKt.c(r110), CollectionsKt.listOf(r112)));
        goto L27
    L33:
        r101.add(new l(ConversationConverterKt.c(r110), 2));
        goto L27
    L30:
        r101.add(new l(ConversationConverterKt.c(r110), 2));
    L40:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (((n) getRequest()).f559250a == false) goto L35;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r100.iterator();
    L18:
        if (r114.hasNext() == false) goto L22;
        String r115 = ((ConversationEntity) r114.next()).getBriefMessageLocalId();
        if (r115 == null) goto L18;
        r113.add(r115);
        goto L18
    L22:
        Set<String> r116 = CollectionsKt.toSet(r113);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = f(r116, r103);
        if (r105 != r106) goto L25;
        return r106;
    L35:
        Iterator<ConversationEntity> r117 = r100.iterator();
    L37:
        if (r117.hasNext() == false) goto L40;
        r101.add(new l(ConversationConverterKt.c(r117.next()), 2));
    L7:
        r103 = new LoadLocalConversationsProcessor$associateBriefMessage$1(this, r102);
        goto L8
    }

    public final Object g(List<ConversationEntity> r100, int r101, Continuation<? super wc9.i> r102) {
        if ((r102 instanceof LoadLocalConversationsProcessor$transformPageData$1) == false) goto L7;
        LoadLocalConversationsProcessor$transformPageData$1 r103 = (LoadLocalConversationsProcessor$transformPageData$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.I$0;
        List<l> r108 = (List) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L23:
        if (r101 != 0) goto L25;
        int r109 = wc9.i.f559236e;
        Intrinsics.checkNotNullParameter(r108, "data");
        return new wc9.i(r108, true, 0, false);
    L25:
        int r110 = wc9.i.f559236e;
        Intrinsics.checkNotNullParameter(r108, "data");
        return new wc9.i(r108, true, r101, false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r100.isEmpty() == false) goto L18;
        return null;
    L18:
        List<l> r111 = new ArrayList();
        r103.L$0 = r111;
        r103.I$0 = r101;
        r103.label = 1;
        if (e(r100, r111, r103) != r106) goto L21;
        return r106;
    L21:
        r108 = r111;
    L7:
        r103 = new LoadLocalConversationsProcessor$transformPageData$1(this, r102);
        goto L8
    }
}
