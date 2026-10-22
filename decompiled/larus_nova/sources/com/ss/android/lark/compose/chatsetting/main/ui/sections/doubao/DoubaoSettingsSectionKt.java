package com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.larus.nova.R;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingDividerKt;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.SwitchSettingRowKt;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes35.dex */
public final class DoubaoSettingsSectionKt {
    public static final void a(final a r310, final a r311, final Function1<? super Boolean, Unit> r312, final Function1<? super Boolean, Unit> r313, String r314, Function2<? super String, ? super String, String> r315, Composer r316, final int r317, final int r410) {
        Intrinsics.checkNotNullParameter(r310, "useDoubaoInChatState");
        Intrinsics.checkNotNullParameter(r311, "doubaoProactiveReplyState");
        Intrinsics.checkNotNullParameter(r312, "onUseDoubaoInChatChange");
        Intrinsics.checkNotNullParameter(r313, "onDoubaoProactiveReplyChange");
        Composer r110 = r316.startRestartGroup(-350298000);
        if ((r410 & 1) == 0) goto L6;
        int r100 = r317 | 6;
    L14:
        if ((r410 & 2) == 0) goto L17;
        r100 = r100 | 48;
    L24:
        if ((r410 & 4) == 0) goto L27;
        r100 = r100 | 384;
    L34:
        if ((r410 & 8) == 0) goto L37;
        r100 = r100 | 3072;
    L43:
        int r101 = r410 & 16;
        if (r101 == 0) goto L47;
        r100 = r100 | 24576;
    L53:
        String r102 = r314;
    L54:
        int r103 = r410 & 32;
        if (r103 == 0) goto L58;
        r100 = r100 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    L64:
        final Function2<? super String, ? super String, String> r104 = r315;
    L65:
        int r105 = r100;
        if ((74899 & r105) != 74898) goto L72;
        if (r110.getSkipping() == false) goto L72;
        r110.skipToGroupEnd();
        final String r106 = r102;
    L99:
        ScopeUpdateScope r111 = r110.endRestartGroup();
        if (r111 == null) goto L103;
        r111.updateScope(new DoubaoSettingsSectionKt$DoubaoSettingsSection$2(r310, r311, r312, r313, r106, r104, r317, r410));
        return;
    L103:
        return;
    L72:
        if (r101 == 0) goto L74;
        String r112 = null;
    L75:
        if (r103 == 0) goto L81;
        r110.startReplaceGroup(1849434622);
        Object r107 = r110.rememberedValue();
        if (r107 != Composer.Companion.getEmpty()) goto L79;
        r107 = DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1.INSTANCE;
        r110.updateRememberedValue(r107);
    L79:
        r110.endReplaceGroup();
        r104 = (Function2) ((KFunction) r107);
    L81:
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventStart(-350298000, r105, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao.DoubaoSettingsSection (DoubaoSettingsSection.kt:25)");
    L83:
        r110.startReplaceGroup(5004770);
        if ((57344 & r105) != 16384) goto L86;
        boolean r108 = true;
    L87:
        Object r109 = r110.rememberedValue();
        if (r108 == false) goto L90;
    L91:
        if (r112 != null) goto L93;
        r109 = ((itb.a) LarkContext.spiByDwarf(itb.a.class)).i();
    L94:
        r110.updateRememberedValue(r109);
    L95:
        String r113 = (String) r109;
        r110.endReplaceGroup();
        String r114 = r104.invoke(StringResources_androidKt.stringResource(R.string.LarkIM_Chat_ChatUseDoubao_Switch, r110, 0), r113);
        Lazy r115 = ChatSettingIcons.f417401a;
        ImageVector r116 = (ImageVector) ChatSettingIcons.f417420t.getValue();
        Brush.Companion r210 = Brush.Companion;
        Function2<? super String, ? super String, String> r318 = r104;
        SwitchSettingRowKt.a(r114, r310, r312, null, new com.ss.android.lark.compose.chatsetting.common.ui.widget.a(r116, Brush.Companion.m4783verticalGradient8A3gB4$default(r210, CollectionsKt.listOf(new Color[]{Color.m4817boximpl(ColorKt.Color(4282427903L)), Color.m4817boximpl(ColorKt.Color(4278216959L))}), 0.0f, 0.0f, 0, 14, null)), false, r110, ((r105 << 3) & 112) | (r105 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT), 40);
        SettingDividerKt.a(null, 0.0f, r110, 0, 3);
        SwitchSettingRowKt.a(r318.invoke(StringResources_androidKt.stringResource(R.string.LarkIM_Chat_ProactiveReply_Switch, r110, 0), r113), r311, r313, null, new com.ss.android.lark.compose.chatsetting.common.ui.widget.a((ImageVector) ChatSettingIcons.f417421u.getValue(), Brush.Companion.m4783verticalGradient8A3gB4$default(r210, CollectionsKt.listOf(new Color[]{Color.m4817boximpl(ColorKt.Color(4282427903L)), Color.m4817boximpl(ColorKt.Color(4278216959L))}), 0.0f, 0.0f, 0, 14, null)), r310.f417684a, r110, (r105 & 112) | ((r105 >> 3) & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
    L98:
        r106 = r112;
        r104 = r318;
        goto L99
    L93:
        r109 = r112;
        goto L94
    L90:
        if (r109 != Composer.Companion.getEmpty()) goto L95;
    L86:
        r108 = false;
        goto L87
    L74:
        r112 = r102;
        goto L75
    L58:
        if ((196608 & r317) != 0) goto L64;
        r104 = r315;
        if (r110.changedInstance(r104) == false) goto L62;
        int r117 = 131072;
    L63:
        r100 = r100 | r117;
        goto L65
    L62:
        r117 = 65536;
        goto L63
    L47:
        if ((r317 & 24576) != 0) goto L53;
        r102 = r314;
        if (r110.changed(r102) == false) goto L51;
        int r118 = 16384;
    L52:
        r100 = r100 | r118;
        goto L54
    L51:
        r118 = 8192;
        goto L52
    L37:
        if ((r317 & 3072) != 0) goto L43;
        if (r110.changedInstance(r313) == false) goto L41;
        int r119 = 2048;
    L42:
        r100 = r100 | r119;
        goto L43
    L41:
        r119 = 1024;
        goto L42
    L27:
        if ((r317 & 384) != 0) goto L34;
        if (r110.changedInstance(r312) == false) goto L31;
        int r120 = 256;
    L32:
        r100 = r100 | r120;
        goto L34
    L31:
        r120 = 128;
        goto L32
    L17:
        if ((r317 & 48) != 0) goto L24;
        if (r110.changed(r311) == false) goto L21;
        int r121 = 32;
    L22:
        r100 = r100 | r121;
        goto L24
    L21:
        r121 = 16;
        goto L22
    L6:
        if ((r317 & 6) == 0) goto L8;
        r100 = r317;
        goto L14
    L8:
        if (r110.changed(r310) == false) goto L10;
        int r122 = 4;
    L11:
        r100 = r122 | r317;
        goto L14
    L10:
        r122 = 2;
        goto L11
    }
}
