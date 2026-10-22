package com.larus.kmp.voice_setting.voice.base.publiclist;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class PublicVoiceListLoaderKt {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351804a = null;

        static {
            int[] r100 = new int[PublicVoiceListRequestKind.values().length];
            r100[PublicVoiceListRequestKind.FIRST_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PublicVoiceListRequestKind.LOAD_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f351804a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(com.larus.kmp.voice_setting.voice.base.publiclist.a r110, PublicVoiceListRequestKind r111, List<SpeakerVoice> r112, Continuation<? super c> r113) {
        if ((r113 instanceof PublicVoiceListLoaderKt$load$1) == false) goto L7;
        PublicVoiceListLoaderKt$load$1 r100 = (PublicVoiceListLoaderKt$load$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r115 = r100.I$0;
        r112 = (List) r100.L$2;
        r111 = (PublicVoiceListRequestKind) r100.L$1;
        com.larus.kmp.voice_setting.voice.base.publiclist.a r104 = (com.larus.kmp.voice_setting.voice.base.publiclist.a) r100.L$0;
        ResultKt.throwOnFailure(r114);
        int r105 = r115;
        com.larus.kmp.voice_setting.voice.base.publiclist.a r106 = r104;
    L25:
        com.larus.kmp.voice_setting.voice.network.b r116 = (com.larus.kmp.voice_setting.voice.network.b) r114;
        String r107 = "";
        String r117 = null;
        Boolean r118 = null;
        if ((r116 instanceof com.larus.kmp.voice_setting.voice.network.b.C4393b) == false) goto L78;
        com.larus.kmp.voice_setting.voice.network.b.C4393b r119 = (com.larus.kmp.voice_setting.voice.network.b.C4393b) r116;
        T r120 = r119.f353993a.f353987d;
        if ((r120 instanceof ah9.e) == false) goto L30;
        ah9.e r121 = (ah9.e) r120;
    L31:
        int r108 = b.f351828a;
        StringBuilder r109 = new StringBuilder("[loader:public_list:network:end] kind=");
        r109.append(r111);
        r109.append(" page=");
        r109.append(r105);
        r109.append(" fromTts=");
        r109.append(r106.f351823a);
        r109.append(" success=true listSize=");
        if (r121 == null) goto L36;
        List<SpeakerVoice> r122 = r121.a();
        if (r122 == null) goto L36;
        int r123 = r122.size();
    L37:
        r109.append(r123);
        r109.append(" hasMore=");
        if (r121 == null) goto L40;
        Boolean r124 = r121.f3451b;
    L41:
        r109.append(r124);
        r109.append(" bizCode=");
        r109.append(r119.f353993a.f353984a);
        r109.append(" bizMsg=");
        String r125 = r119.f353993a.f353985b;
        if (r125 == null) goto L45;
        r107 = r125;
    L45:
        r109.append(r107);
        b.a(r109.toString());
        int r126 = a.f351804a[r111.ordinal()];
        if (r126 == 1) goto L68;
        if (r126 != 2) goto L67;
        if (r121 == null) goto L50;
        List<SpeakerVoice> r127 = r121.a();
    L51:
        if (r127 != null) goto L54;
        r127 = CollectionsKt.emptyList();
    L54:
        if (r127.isEmpty() == true) goto L73;
        r112 = CollectionsKt.toMutableList(r112);
        LinkedHashSet r128 = new LinkedHashSet();
        Iterator<T> r129 = r112.iterator();
    L58:
        if (r129.hasNext() == false) goto L60;
        r128.add(((SpeakerVoice) r129.next()).getId());
        goto L58
    L60:
        Iterator<T> r130 = r127.iterator();
    L62:
        if (r130.hasNext() == false) goto L73;
        SpeakerVoice r131 = (SpeakerVoice) r130.next();
        if (r128.add(r131.getId()) == false) goto L62;
        r112.add(r131);
    L73:
        com.larus.kmp.voice_setting.voice.base.publiclist.a r132 = com.larus.kmp.voice_setting.voice.base.publiclist.a.a(r106, false, null, null, r105, 23);
        ah9.g r133 = new ah9.g(3, r112);
        int r134 = jh9.g.f499116a;
        if (r121 == null) goto L99;
        r118 = r121.f3451b;
    L99:
        return new c(r132, r133, jh9.g.e(r118));
    L50:
        r127 = null;
        goto L51
    L67:
        throw new NoWhenBranchMatchedException();
    L68:
        if (r121 == null) goto L70;
        r112 = r121.a();
    L71:
        if (r112 != null) goto L73;
        r112 = CollectionsKt.emptyList();
        goto L73
    L70:
        r112 = null;
        goto L71
    L40:
        r124 = null;
    L36:
        r123 = 0;
        goto L37
    L30:
        r121 = null;
        goto L31
    L78:
        if ((r116 instanceof com.larus.kmp.voice_setting.voice.network.b.a) == false) goto L92;
        int r135 = b.f351828a;
        StringBuilder r136 = new StringBuilder("[loader:public_list:network:end] kind=");
        r136.append(r111);
        r136.append(" page=");
        r136.append(r105);
        r136.append(" fromTts=");
        r136.append(r106.f351823a);
        r136.append(" success=false code=");
        com.larus.kmp.voice_setting.voice.network.b.a r137 = (com.larus.kmp.voice_setting.voice.network.b.a) r116;
        r136.append(r137.f353990a);
        r136.append(" msg=");
        r136.append(r137.f353991b);
        r136.append(" throwable=");
        Throwable r138 = r137.f353992c;
        if (r138 == null) goto L82;
        r117 = r138.getMessage();
    L82:
        if (r117 == null) goto L85;
        r107 = r117;
    L85:
        r136.append(r107);
        b.a(r136.toString());
        com.larus.kmp.voice_setting.voice.base.publiclist.a r139 = com.larus.kmp.voice_setting.voice.base.publiclist.a.a(r106, false, null, null, r105, 23);
        if (r111 == PublicVoiceListRequestKind.LOAD_MORE) goto L90;
        r112 = CollectionsKt.emptyList();
    L90:
        return new c(r139, new ah9.g(1, r112), 1);
    L92:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        int r140 = a.f351804a[r111.ordinal()];
        if (r140 == 1) goto L20;
        if (r140 != 2) goto L19;
        int r141 = r110.f351826d + 1;
    L21:
        CoroutineDispatcher r142 = Dispatchers.getIO();
        PublicVoiceListLoaderKt$load$response$1 r143 = new PublicVoiceListLoaderKt$load$response$1(r111, r110, r141, r112, null);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.I$0 = r141;
        r100.label = 1;
        Object r144 = BuildersKt.withContext(r142, r143, r100);
        if (r144 != r102) goto L24;
        return r102;
    L24:
        r106 = r110;
        r105 = r141;
        r114 = r144;
        goto L25
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r141 = 1;
    L7:
        r100 = new PublicVoiceListLoaderKt$load$1(r113);
        goto L8
    }

    public static final com.larus.kmp.voice_setting.voice.base.publiclist.a b(com.larus.kmp.voice_setting.voice.base.publiclist.a r100, boolean r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r110, UserInfo.LANGUAGECODE);
        return com.larus.kmp.voice_setting.voice.base.publiclist.a.a(r100, r101, r102, r110, 1, 16);
    }
}
