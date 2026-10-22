package com.larus.im.internal.core.conversation.receiver;

import com.larus.im.internal.jni.bean.OmniConversation;
import com.larus.im.internal.jni.converter.OmniConversationConverterKt;
import com.larus.im.internal.jni.observer.OmniConversationDispatcherKt;
import com.larus.im.internal.jni.observer.OmniConversationObserver;
import com.larus.im.service.b0;
import com.larus.im.service.d0;
import com.larus.im.service.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class ConversationDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<z<List<e>>> f347638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.a<String, CopyOnWriteArrayList<d0<e>>> f347639b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b0> f347640c = null;

    public static final class a implements OmniConversationObserver {
        public a() {
        }

        @Override // com.larus.im.internal.jni.observer.OmniConversationObserver
        public final void notifyChange(List<OmniConversation> r100) {
            Intrinsics.checkNotNullParameter(r100, "conversations");
            CopyOnWriteArrayList<z<List<e>>> r101 = ConversationDispatcher.f347638a;
            List<OmniConversation> r102 = r100;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.add(OmniConversationConverterKt.toConversation((OmniConversation) r104.next()));
            goto L4
        L6:
            ConversationDispatcher.a(r103);
        }

        @Override // com.larus.im.internal.jni.observer.OmniConversationObserver
        public final void notifyReplace(String r100, OmniConversation r101, OmniConversation r102) {
            Intrinsics.checkNotNullParameter(r100, "localCvsId");
            Intrinsics.checkNotNullParameter(r102, "remote");
            CopyOnWriteArrayList<z<List<e>>> r103 = ConversationDispatcher.f347638a;
            if (r101 == null) goto L5;
            e r104 = OmniConversationConverterKt.toConversation(r101);
        L6:
            ConversationDispatcher.b(r100, r104, OmniConversationConverterKt.toConversation(r102));
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        com.larus.im.internal.delegate.a.f348188b.i("ConversationDispatcher", "init");
        OmniConversationDispatcherKt.GetOmniConversationDispatcher().registerGlobal(new a());
        f347638a = new CopyOnWriteArrayList();
        f347639b = new vt7.a();
        f347640c = new CopyOnWriteArrayList();
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "conversations");
        com.larus.im.internal.database.utils.e.d(new ConversationDispatcher$notifyChange$1(r100, null));
    }

    public static void b(String r100, e r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "localCvsId");
        Intrinsics.checkNotNullParameter(r102, "remote");
        com.larus.im.internal.database.utils.e.d(new ConversationDispatcher$notifyReplace$1(r100, r102, r101, null));
    }
}
