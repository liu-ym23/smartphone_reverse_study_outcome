package com.larus.kmp.voice_setting.voice.base.multitab;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.base.api.i;
import com.larus.kmp.voice_setting.voice.bean.RequestType;
import com.larus.kmp.voice_setting.voice.component.VoiceListKind;
import eh9.l;
import java.util.ArrayList;
import java.util.List;
import jh9.g;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class MultiTabVoiceLoaderKt {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351784a = null;

        static {
            int[] r100 = new int[MultiTabVoiceRequestKind.values().length];
            r100[MultiTabVoiceRequestKind.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MultiTabVoiceRequestKind.LOAD_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f351784a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(b r210, l r211, ah9.c r212, Continuation<? super d> r213) {
        l r100 = r211;
        ah9.c r101 = r212;
        if ((r213 instanceof MultiTabVoiceLoaderKt$load$1) == false) goto L7;
        MultiTabVoiceLoaderKt$load$1 r102 = (MultiTabVoiceLoaderKt$load$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r110 = "";
        List r111 = null;
        Boolean r112 = null;
        r111 = null;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        int r107 = r102.I$0;
        ah9.c r108 = (ah9.c) r102.L$2;
        l r109 = (l) r102.L$1;
        b r113 = (b) r102.L$0;
        ResultKt.throwOnFailure(r104);
        b r114 = r113;
        r101 = r108;
        r100 = r109;
    L89:
        com.larus.kmp.voice_setting.voice.network.b r115 = (com.larus.kmp.voice_setting.voice.network.b) r104;
        int r116 = c.f351801a;
        StringBuilder r117 = new StringBuilder("[loader:multi:network:io:end] ownerTab=");
        r117.append(r114.f351797c);
        r117.append(" serverTab=");
        i r118 = r114.f351798d;
        if (r118 == null) goto L92;
        String r119 = r118.f351776b;
    L93:
        if (r119 != null) goto L95;
        r119 = "";
    L95:
        r117.append(r119);
        r117.append(" page=");
        r117.append(r107);
        c.a(r117.toString());
        if ((r115 instanceof com.larus.kmp.voice_setting.voice.network.b.C4393b) == false) goto L158;
        T r120 = ((com.larus.kmp.voice_setting.voice.network.b.C4393b) r115).f353993a.f353987d;
        if ((r120 instanceof ah9.e) == false) goto L100;
        ah9.e r121 = (ah9.e) r120;
    L101:
        if (r101 == null) goto L106;
        List<SpeakerVoice> r122 = r101.f3446a;
        if (r122 == null) goto L106;
        List r123 = CollectionsKt.toMutableList(r122);
        if (r123 == null) goto L106;
    L107:
        MultiTabVoiceRequestKind r124 = e.a(r100);
        int[] r125 = a.f351784a;
        int r126 = r125[r124.ordinal()];
        if (r126 != 1) goto L110;
        if (r121 == null) goto L123;
        List<SpeakerVoice> r127 = r121.a();
        if (r127 == null) goto L123;
        r123 = CollectionsKt.toMutableList(r127);
    L124:
        StringBuilder r128 = new StringBuilder("[loader:multi:success] ownerTab=");
        r128.append(r114.f351797c);
        r128.append(" serverTab=");
        i r129 = r114.f351798d;
        if (r129 == null) goto L127;
        String r130 = r129.f351776b;
    L128:
        if (r130 == null) goto L131;
        r110 = r130;
    L131:
        r128.append(r110);
        r128.append(" page=");
        r128.append(r107);
        r128.append(" server=");
        if (r121 == null) goto L136;
        List<SpeakerVoice> r131 = r121.a();
        if (r131 == null) goto L136;
        int r132 = r131.size();
    L137:
        r128.append(r132);
        r128.append(" merged=");
        if (r123 == null) goto L140;
        int r133 = r123.size();
    L141:
        r128.append(r133);
        r128.append(" hasMore=");
        if (r121 == null) goto L144;
        Boolean r134 = r121.f3451b;
    L145:
        r128.append(r134);
        c.a(r128.toString());
        b r135 = b.a(r114, null, null, null, null, r107, 47);
        int r136 = g.f499116a;
        if (r121 == null) goto L148;
        r112 = r121.f3451b;
    L148:
        Integer r137 = Boxing.boxInt(g.e(r112));
        Integer r138 = Boxing.boxInt(3);
        int r139 = r125[e.a(r100).ordinal()];
        if (r139 != 1) goto L151;
        RequestType r140 = RequestType.INIT;
    L156:
        d r141 = new d(r135, new ah9.c(r123, r137, r138, r140));
    L186:
        return r141;
    L151:
        if (r139 != 2) goto L154;
        r140 = RequestType.LOAD_MORE;
        goto L156
    L154:
        throw new NoWhenBranchMatchedException();
    L144:
        r134 = null;
        goto L145
    L140:
        r133 = 0;
    L136:
        r132 = 0;
        goto L137
    L127:
        r130 = null;
    L123:
        r123 = null;
        goto L124
    L110:
        if (r126 != 2) goto L118;
        if (r121 == null) goto L113;
        List<SpeakerVoice> r142 = r121.a();
    L114:
        if (r142 != null) goto L116;
        r142 = CollectionsKt.emptyList();
    L116:
        r123.addAll(r142);
        goto L124
    L113:
        r142 = null;
        goto L114
    L118:
        throw new NoWhenBranchMatchedException();
    L106:
        r123 = new ArrayList();
        goto L107
    L100:
        r121 = null;
        goto L101
    L158:
        if ((r115 instanceof com.larus.kmp.voice_setting.voice.network.b.a) == false) goto L188;
        StringBuilder r143 = new StringBuilder("[loader:multi:error] ownerTab=");
        r143.append(r114.f351797c);
        r143.append(" serverTab=");
        i r144 = r114.f351798d;
        if (r144 == null) goto L162;
        String r145 = r144.f351776b;
    L163:
        if (r145 == null) goto L166;
        r110 = r145;
    L166:
        r143.append(r110);
        r143.append(" page=");
        r143.append(r107);
        r143.append(" previous=");
        if (r101 == null) goto L171;
        List<SpeakerVoice> r146 = r101.f3446a;
        if (r146 == null) goto L171;
        int r147 = r146.size();
    L172:
        r143.append(r147);
        c.a(r143.toString());
        b r148 = b.a(r114, null, null, null, null, r107, 47);
        if (r101 == null) goto L177;
        List<SpeakerVoice> r149 = r101.f3446a;
        if (r149 == null) goto L177;
        r111 = CollectionsKt.toMutableList(r149);
    L177:
        Integer r150 = Boxing.boxInt(1);
        Integer r151 = Boxing.boxInt(1);
        int r152 = a.f351784a[e.a(r100).ordinal()];
        if (r152 != 1) goto L180;
        RequestType r153 = RequestType.INIT;
    L185:
        r141 = new d(r148, new ah9.c(r111, r150, r151, r153));
        goto L186
    L180:
        if (r152 != 2) goto L183;
        r153 = RequestType.LOAD_MORE;
        goto L185
    L183:
        throw new NoWhenBranchMatchedException();
    L171:
        r147 = 0;
        goto L172
    L162:
        r145 = null;
        goto L163
    L188:
        throw new NoWhenBranchMatchedException();
    L92:
        r119 = null;
        goto L93
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r154 = r210.f351797c;
        if (StringsKt.isBlank(r154) == false) goto L23;
        i r155 = r210.f351798d;
        if (r155 == null) goto L19;
        r154 = r155.f351776b;
    L20:
        if (r154 != null) goto L23;
        r154 = "";
        goto L23
    L19:
        r154 = null;
    L23:
        if ((!StringsKt.isBlank(r154)) == true) goto L26;
        r154 = null;
    L26:
        VoiceListKind r156 = VoiceListKind.DOUBLE_TAB;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r156 != null) goto L29;
    L31:
        if (r154 != null) goto L33;
    L35:
        boolean r157 = true;
    L37:
        if (r157 == true) goto L50;
        int r158 = c.f351801a;
        StringBuilder r159 = new StringBuilder("[loader:multi:skip] ownerTab=");
        r159.append(r210.f351797c);
        r159.append(" serverTab=");
        i r160 = r210.f351798d;
        if (r160 == null) goto L41;
        String r161 = r160.f351776b;
    L42:
        if (r161 != null) goto L44;
        r161 = "";
    L44:
        r159.append(r161);
        r159.append(" requestActive=");
        String r162 = r100.f472742g;
        if (r162 == null) goto L48;
        r110 = r162;
    L48:
        r159.append(r110);
        r159.append(" trigger=");
        r159.append(r100.f472737b);
        r159.append(" kind=");
        r159.append(r100.f472736a);
        c.a(r159.toString());
        return null;
    L41:
        r161 = null;
        goto L42
    L50:
        int r163 = a.f351784a[e.a(r211).ordinal()];
        if (r163 == 1) goto L56;
        if (r163 != 2) goto L55;
        int r164 = r210.f351799e + 1;
    L57:
        int r165 = c.f351801a;
        StringBuilder r166 = new StringBuilder("[loader:multi:start] ownerTab=");
        r166.append(r210.f351797c);
        r166.append(" serverTab=");
        i r167 = r210.f351798d;
        if (r167 == null) goto L60;
        String r168 = r167.f351776b;
    L61:
        if (r168 != null) goto L63;
        r168 = "";
    L63:
        r166.append(r168);
        r166.append(" trigger=");
        r166.append(r100.f472737b);
        r166.append(" page=");
        r166.append(r164);
        r166.append(" previous=");
        if (r101 == null) goto L68;
        List<SpeakerVoice> r169 = r101.f3446a;
        if (r169 == null) goto L68;
        int r170 = r169.size();
    L69:
        r166.append(r170);
        r166.append(" recommendType=");
        i r171 = r210.f351798d;
        if (r171 == null) goto L72;
        Integer r172 = Boxing.boxInt(r171.f351777c);
    L73:
        r166.append(r172);
        c.a(r166.toString());
        if (com.larus.kmp.voice_setting.voice.base.api.e.a() == false) goto L76;
        String r173 = PriorityModule.SCENE_MULTI;
    L77:
        int r174 = r210.f351800f;
        i r175 = r210.f351798d;
        if (r175 == null) goto L80;
        Integer r176 = Boxing.boxInt(r175.f351777c);
    L81:
        i r177 = r210.f351798d;
        if (r177 == null) goto L84;
        String r178 = r177.f351776b;
    L85:
        String r179 = r210.f351795a;
        Intrinsics.checkNotNullParameter(r173, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r179, "botId");
        com.larus.kmp.voice_setting.voice.base.multitab.a r180 = new com.larus.kmp.voice_setting.voice.base.multitab.a(r164, r174, r176, r178, r173, r179);
        CoroutineDispatcher r181 = Dispatchers.getIO();
        MultiTabVoiceLoaderKt$load$response$1 r182 = new MultiTabVoiceLoaderKt$load$response$1(r210, r164, r180, null);
        r102.L$0 = r210;
        r102.L$1 = r100;
        r102.L$2 = r101;
        r102.I$0 = r164;
        r102.label = 1;
        Object r183 = BuildersKt.withContext(r181, r182, r102);
        if (r183 != r105) goto L88;
        return r105;
    L88:
        r114 = r210;
        r107 = r164;
        r104 = r183;
        goto L89
    L84:
        r178 = null;
        goto L85
    L80:
        r176 = null;
        goto L81
    L76:
        r173 = r210.f351796b;
        goto L77
    L72:
        r172 = null;
    L68:
        r170 = 0;
        goto L69
    L60:
        r168 = null;
        goto L61
    L55:
        throw new NoWhenBranchMatchedException();
    L56:
        r164 = 1;
        goto L57
    L33:
        if (Intrinsics.areEqual(r100.f472742g, r154) == true) goto L35;
    L34:
        r157 = false;
        goto L37
    L29:
        if (r100.f472736a == r156) goto L31;
    L7:
        r102 = new MultiTabVoiceLoaderKt$load$1(r213);
        goto L8
    }
}
