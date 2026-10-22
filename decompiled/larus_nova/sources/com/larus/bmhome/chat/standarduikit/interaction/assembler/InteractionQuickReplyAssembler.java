package com.larus.bmhome.chat.standarduikit.interaction.assembler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.standarduikit.interaction.view.InteractionQuickReplyView;
import com.larus.bmhome.chat.standarduikit.interaction.view.InteractionQuickReplyViewInput;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.f;
import com.larus.bmhome.chat.standarduikit.interaction.viewmodel.m;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyDecisionContext;
import com.larus.im.bean.message.block.QuickReplyEnvironment;
import com.larus.im.bean.message.block.QuickReplyHighlightType;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.h;

/* JADX INFO: loaded from: classes26.dex */
public final class InteractionQuickReplyAssembler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309297b;

    public final void a() {
        InteractionQuickReplyView r100 = (InteractionQuickReplyView) this.f309296a.getValue();
        m r101 = (m) this.f309297b.getValue();
        f r102 = r101.f309377b;
        if (r102 == null) goto L5;
        QuickReplyBlock r103 = r102.f309359h;
    L7:
        if (r103 != null) goto L9;
        InteractionQuickReplyViewInput r104 = new InteractionQuickReplyViewInput(null, null, null, null, null, null, null, null, 511);
    L96:
        final m.b r105 = ((m) this.f309297b.getValue()).f309388m;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "input");
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_OUTPUT);
        boolean r106 = h.f552477a;
        if (h.a(null) == false) goto L99;
        String r107 = r104.f309307b;
    L100:
        if (r107 != null) goto L102;
    L105:
        boolean r108 = true;
    L106:
        if (r108 == true) goto L109;
        e1.x(r100.f309301a.f358675h);
        ImageLoaderKt.u(r100.f309301a.f358674g, r107, "block_button_icon");
    L111:
        boolean r109 = true;
    L113:
        CharSequence r110 = r104.f309309d;
        if (r110 != null) goto L116;
    L119:
        boolean r210 = true;
    L120:
        boolean r111 = !r210;
        if (r109 == true) goto L125;
        if (r111 == true) goto L125;
        boolean r112 = false;
    L126:
        LinearLayout r113 = r100.f309301a.f358677j;
        if (r112 == false) goto L129;
        int r114 = 0;
    L130:
        r113.setVisibility(r114);
        AppCompatTextView r115 = r100.f309301a.f358676i;
        if (r111 == false) goto L133;
        int r116 = 0;
    L134:
        r115.setVisibility(r116);
        r100.f309301a.f358676i.setText(r104.f309309d);
        CharSequence r117 = r104.f309310e;
        if (r117 != null) goto L137;
    L140:
        boolean r211 = true;
    L141:
        boolean r118 = !r211;
        AppCompatTextView r119 = r100.f309301a.f358683p;
        if (r118 == false) goto L144;
        int r120 = 0;
    L145:
        r119.setVisibility(r120);
        r100.f309301a.f358683p.setText(r104.f309310e);
        CharSequence r121 = r104.f309311f;
        if (r121 != null) goto L148;
    L151:
        boolean r212 = true;
    L152:
        boolean r122 = !r212;
        AppCompatTextView r123 = r100.f309301a.f358673f;
        if (r122 == false) goto L155;
        int r124 = 0;
    L156:
        r123.setVisibility(r124);
        r100.f309301a.f358673f.setText(r104.f309311f);
        CharSequence r125 = r104.f309312g;
        if (r125 != null) goto L159;
    L162:
        boolean r213 = true;
    L163:
        boolean r126 = !r213;
        LinearLayout r127 = r100.f309301a.f358681n;
        if (r126 == false) goto L166;
        int r128 = 0;
    L167:
        r127.setVisibility(r128);
        r100.f309301a.f358680m.setText(r104.f309312g);
        Space r129 = r100.f309301a.f358678k;
        if (r112 == false) goto L172;
        if (r118 == true) goto L171;
        if (r122 == false) goto L172;
    L171:
        boolean r130 = true;
    L173:
        if (r130 == false) goto L175;
        int r131 = 0;
    L176:
        r129.setVisibility(r131);
        Space r132 = r100.f309301a.f358682o;
        if (r118 == false) goto L180;
        if (r122 == false) goto L180;
        boolean r133 = true;
    L181:
        if (r133 == false) goto L183;
        int r134 = 0;
    L184:
        r132.setVisibility(r134);
        Space r135 = r100.f309301a.f358679l;
        if (r126 == false) goto L190;
        if (r112 == true) goto L189;
        if (r118 == true) goto L189;
        if (r122 == false) goto L190;
    L189:
        boolean r136 = true;
    L191:
        if (r136 == false) goto L193;
        int r137 = 0;
    L194:
        r135.setVisibility(r137);
        LinearLayout r138 = r100.f309301a.f358671d;
        if (r112 == true) goto L201;
        if (r118 == true) goto L201;
        if (r122 == true) goto L201;
        if (r126 == true) goto L201;
        boolean r139 = false;
    L202:
        if (r139 == false) goto L204;
        int r140 = 0;
    L205:
        r138.setVisibility(r140);
        ScrollView r141 = r100.f309301a.f358672e;
        if (r122 == true) goto L210;
        if (r126 == true) goto L210;
        boolean r142 = false;
    L211:
        if (r142 == false) goto L213;
        int r143 = 0;
    L214:
        r141.setVisibility(r143);
        List<InteractionQuickReplyViewInput.Button> r144 = r104.f309313h;
        Integer r145 = r104.f309314i;
        r100.f309301a.f358670c.removeAllViews();
        if (r144.isEmpty() == false) goto L217;
        e1.o(r100.f309301a.f358670c);
        e1.o(r100.f309301a.f358669b);
    L287:
        if (r100.f309302b == true) goto L303;
        r100.f309302b = true;
        r105.b();
        return;
    L303:
        return;
    L217:
        e1.x(r100.f309301a.f358670c);
        e1.x(r100.f309301a.f358669b);
        if (r144.size() != 2) goto L220;
        int r146 = 1;
    L221:
        r100.f309301a.f358670c.setOrientation(r146 ^ 1);
        Iterator<T> r147 = r144.iterator();
        final int r148 = 0;
    L223:
        if (r147.hasNext() == false) goto L287;
        Object r149 = r147.next();
        int r150 = r148 + 1;
        if (r148 >= 0) goto L227;
        CollectionsKt.throwIndexOverflow();
    L227:
        InteractionQuickReplyViewInput.Button r151 = (InteractionQuickReplyViewInput.Button) r149;
        if (r145 != null) goto L231;
    L233:
        boolean r152 = false;
    L234:
        if (r145 == null) goto L237;
        if (r152 == true) goto L237;
        boolean r153 = true;
    L238:
        LinearLayout r154 = r100.f309301a.f358670c;
        if (r151.f309316b != InteractionQuickReplyViewInput.Button.Style.PRIMARY) goto L241;
        boolean r155 = true;
    L243:
        if (r146 == 0) goto L253;
        View r156 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_interaction_quick_reply_button_horizontal, r100.f309301a.f358670c, false);
        TextView r157 = (TextView) ViewBindings.findChildViewById(r156, R.id.button_label);
        if (r157 == null) goto L250;
        FrameLayout r158 = (FrameLayout) r156;
        FrameLayout r159 = (FrameLayout) ViewBindings.findChildViewById(r156, R.id.loading_container);
        if (r159 == null) goto L249;
        InteractionQuickReplyView.a r160 = new InteractionQuickReplyView.a(r158, r157, r159);
    L258:
        FrameLayout r161 = r160.f309303a;
        r161.setSelected(r155);
        r161.setActivated(r153);
        r160.f309304b.setText(r151.f309315a);
        TextView r162 = r160.f309304b;
        if ((!r152) == false) goto L261;
        int r163 = 0;
    L262:
        r162.setVisibility(r163);
        FrameLayout r164 = r160.f309305c;
        if (r152 == false) goto L265;
        int r165 = 0;
    L266:
        r164.setVisibility(r165);
        if (r152 == false) goto L269;
        FrameLayout r166 = r160.f309305c;
        com.larus.common_ui.dbx.component.b r167 = new com.larus.common_ui.dbx.component.b(r100.getContext());
        r167.setRingColor(r160.f309304b.getCurrentTextColor());
        r167.f327024d = true;
        r167.a();
        r166.addView(r167, new FrameLayout.LayoutParams(-1, -1));
    L269:
        r161.setAlpha(1.0f);
        if (r151.f309317c == true) goto L272;
        r161.setAlpha(0.3f);
    L275:
        if (r153 == true) goto L280;
        if (r152 == true) goto L280;
        if (r151.f309317c == false) goto L280;
        e1.d(r161, new sl8.a(r105, r148));
    L281:
        r154.addView(r161);
        r148 = r150;
        r145 = r145;
    L280:
        r161.setClickable(false);
        r161.setFocusable(false);
        goto L281
    L272:
        if (r155 == false) goto L275;
        if (r153 == false) goto L275;
        r161.setAlpha(0.2f);
        goto L275
    L265:
        r165 = 8;
        goto L266
    L261:
        r163 = 8;
        goto L262
    L249:
        int r168 = R.id.loading_container;
    L252:
        throw new NullPointerException("Missing required view with ID: ".concat(r156.getResources().getResourceName(r168)));
    L250:
        r168 = R.id.button_label;
        goto L252
    L253:
        View r169 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_interaction_quick_reply_button_vertical, r100.f309301a.f358670c, false);
        TextView r170 = (TextView) ViewBindings.findChildViewById(r169, R.id.button_label);
        if (r170 == null) goto L283;
        FrameLayout r171 = (FrameLayout) r169;
        FrameLayout r172 = (FrameLayout) ViewBindings.findChildViewById(r169, R.id.loading_container);
        if (r172 == null) goto L282;
        r160 = new InteractionQuickReplyView.a(r171, r170, r172);
        goto L258
    L282:
        int r173 = R.id.loading_container;
    L285:
        throw new NullPointerException("Missing required view with ID: ".concat(r169.getResources().getResourceName(r173)));
    L283:
        r173 = R.id.button_label;
        goto L285
    L241:
        r155 = false;
    L237:
        r153 = false;
        goto L238
    L231:
        if (r145.intValue() != r148) goto L233;
        r152 = true;
        goto L234
    L220:
        r146 = 0;
        goto L221
    L213:
        r143 = 8;
    L210:
        r142 = true;
        goto L211
    L204:
        r140 = 8;
    L201:
        r139 = true;
        goto L202
    L193:
        r137 = 8;
    L190:
        r136 = false;
        goto L191
    L183:
        r134 = 8;
    L180:
        r133 = false;
        goto L181
    L175:
        r131 = 8;
    L172:
        r130 = false;
        goto L173
    L166:
        r128 = 8;
        goto L167
    L159:
        if (StringsKt.isBlank(r125) == true) goto L162;
        r213 = false;
        goto L163
    L155:
        r124 = 8;
        goto L156
    L148:
        if (StringsKt.isBlank(r121) == true) goto L151;
        r212 = false;
        goto L152
    L144:
        r120 = 8;
        goto L145
    L137:
        if (StringsKt.isBlank(r117) == true) goto L140;
        r211 = false;
        goto L141
    L133:
        r116 = 8;
        goto L134
    L129:
        r114 = 8;
    L125:
        r112 = true;
        goto L126
    L116:
        if (StringsKt.isBlank(r110) == true) goto L119;
        r210 = false;
        goto L120
    L109:
        if (r104.f309308c == null) goto L112;
        e1.x(r100.f309301a.f358675h);
        r100.f309301a.f358674g.setActualImageResource(r104.f309308c.intValue());
        goto L111
    L112:
        e1.o(r100.f309301a.f358675h);
        r109 = false;
        goto L113
    L102:
        if (r107.length() == 0) goto L105;
        r108 = false;
        goto L106
    L99:
        r107 = r104.f309306a;
        goto L100
    L9:
        if (r102 == null) goto L11;
        QuickReplyBlock r174 = r102.f309359h;
    L12:
        if (r174 == null) goto L14;
        QuickReplyDecisionContext r175 = r174.getDecisionContext();
    L15:
        if (r175 == null) goto L17;
        QuickReplyEnvironment r176 = r175.getEnvironment();
    L18:
        if (r176 == null) goto L22;
        QuickReplyIcon r177 = r176.getIcon();
        if (r177 == null) goto L22;
        String r178 = r177.getUrlLight();
    L23:
        if (r176 == null) goto L27;
        QuickReplyIcon r179 = r176.getIcon();
        if (r179 == null) goto L27;
        String r180 = r179.getUrlDark();
    L28:
        if (r176 == null) goto L30;
        String r181 = r176.getTitle();
    L31:
        if (r175 == null) goto L37;
        String r182 = r175.getTitle();
        if (r182 == null) goto L37;
        if ((!StringsKt.isBlank(r182)) == false) goto L37;
        String r183 = r182;
    L38:
        if (r175 == null) goto L44;
        String r184 = r175.getContent();
        if (r184 == null) goto L44;
        if ((!StringsKt.isBlank(r184)) == false) goto L44;
        String r185 = r184;
    L46:
        if (r175 == null) goto L79;
        List<String> r186 = r175.getSuggestedFolderPath();
        if (r186 == null) goto L79;
        Iterator<T> r187 = r186.iterator();
    L51:
        if (r187.hasNext() == false) goto L62;
        Object r188 = r187.next();
        String r189 = (String) r188;
        if (r189 != null) goto L55;
    L58:
        boolean r190 = true;
    L60:
        if ((!r190) == false) goto L51;
    L63:
        String r191 = (String) r188;
        if (r191 == null) goto L79;
        if (r191.length() != 0) goto L68;
        boolean r192 = true;
    L69:
        if (r192 == false) goto L71;
        String r193 = "";
    L80:
        List<QuickReplyItem> r194 = r101.f309379d;
        ArrayList r195 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r194, 10));
        Iterator<T> r196 = r194.iterator();
    L82:
        if (r196.hasNext() == false) goto L95;
        QuickReplyItem r197 = (QuickReplyItem) r196.next();
        String r198 = r197.getText();
        if (r198 != null) goto L86;
        String r199 = "";
    L87:
        Integer r1100 = r197.getHighlightType();
        int r200 = QuickReplyHighlightType.HIGHLIGHT_TYPE_CONFIRM.getValue();
        if (r1100 != null) goto L91;
    L93:
        InteractionQuickReplyViewInput.Button.Style r201 = InteractionQuickReplyViewInput.Button.Style.SECONDARY;
    L94:
        r195.add(new InteractionQuickReplyViewInput.Button(r199, r201));
        goto L82
    L91:
        if (r1100.intValue() != r200) goto L93;
        r201 = InteractionQuickReplyViewInput.Button.Style.PRIMARY;
        goto L94
    L86:
        r199 = r198;
        goto L87
    L95:
        r104 = new InteractionQuickReplyViewInput(r178, r180, r181, r183, r185, r193, r195, r101.f309380e, 4);
        goto L96
    L71:
        String r202 = StringsKt.trimEnd(r191, new char[]{'/', '\\'});
        if (r202.length() != 0) goto L74;
        boolean r1101 = true;
    L75:
        if (r1101 == false) goto L77;
        String r203 = StringsKt.take(r191, 1);
    L78:
        r193 = r203;
        goto L80
    L77:
        r203 = r202.substring(StringsKt.lastIndexOfAny$default(r202, new char[]{'/', '\\'}, 0, false, 6, null) + 1);
        goto L78
    L74:
        r1101 = false;
        goto L75
    L68:
        r192 = false;
        goto L69
    L55:
        if (StringsKt.isBlank(r189) == true) goto L58;
        r190 = false;
        goto L60
    L62:
        r188 = null;
    L79:
        r193 = null;
    L44:
        r185 = null;
    L37:
        r183 = null;
        goto L38
    L30:
        r181 = null;
    L27:
        r180 = null;
    L22:
        r178 = null;
        goto L23
    L17:
        r176 = null;
        goto L18
    L14:
        r175 = null;
        goto L15
    L11:
        r174 = null;
        goto L12
    L5:
        r103 = null;
        goto L7
    }

    public InteractionQuickReplyAssembler(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f309296a = LazyKt.lazy(new a(r100));
        this.f309297b = LazyKt.lazy(new b(this));
    }
}
