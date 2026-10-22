package ny9;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Image;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements c {
    public final Integer A;
    public final Integer B;
    public final boolean C;
    public final CustomInputInitData D;
    public final boolean E;
    public final Boolean F;
    public final Boolean G;
    public final Boolean H;
    public final Boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Boolean f521233J;
    public final String K;
    public final String L;
    public final lr9.a M;
    public final String N;
    public final String O;
    public final Boolean P;
    public final Integer Q;
    public final Boolean R;
    public final ChatPageContext S;
    public final Fragment T;
    public final Fragment U;
    public final CreationDoSameNotifyInfo V;
    public final String W;
    public final boolean X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f521234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f521235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f521236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatParam f521237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f521238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f521239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f521240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f521241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f521242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f521243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<ResourceExt> f521244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f521245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Integer> f521246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f521247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Image f521248o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ResourceUploadInstantInfo f521249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f521250q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f521251r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<String> f521252s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f521253t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f521254u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final zs8.a f521255v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final by7.e f521256w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f521257x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f521258y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, String> f521259z;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f521234a == r101.f521234a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f521235b, r101.f521235b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f521236c, r101.f521236c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f521237d, r101.f521237d) == true) goto L21;
        return false;
    L21:
        if (this.f521238e == r101.f521238e) goto L24;
        return false;
    L24:
        if (this.f521239f == r101.f521239f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f521240g, r101.f521240g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f521241h, r101.f521241h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f521242i, r101.f521242i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f521243j, r101.f521243j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f521244k, r101.f521244k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f521245l, r101.f521245l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f521246m, r101.f521246m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f521247n, r101.f521247n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f521248o, r101.f521248o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f521249p, r101.f521249p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f521250q, r101.f521250q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f521251r, r101.f521251r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f521252s, r101.f521252s) == true) goto L66;
        return false;
    L66:
        if (this.f521253t == r101.f521253t) goto L69;
        return false;
    L69:
        if (this.f521254u == r101.f521254u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f521255v, r101.f521255v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f521256w, r101.f521256w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f521257x, r101.f521257x) == true) goto L81;
        return false;
    L81:
        if (this.f521258y == r101.f521258y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f521259z, r101.f521259z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L99;
        return false;
    L99:
        if (this.E == r101.E) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.f521233J, r101.f521233J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.N, r101.N) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r101.O) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.P, r101.P) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r101.Q) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.R, r101.R) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r101.S) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.T, r101.T) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.U, r101.U) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.V, r101.V) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.W, r101.W) == true) goto L156;
        return false;
    L156:
        if (this.X == r101.X) goto L158;
        return false;
    L158:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f521234a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f521235b.hashCode()) * 31) + this.f521236c.hashCode()) * 31;
        ChatParam r103 = this.f521237d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.f521238e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f521239f == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        String r111 = this.f521240g;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f521241h;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f521242i;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f521243j;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        List<ResourceExt> r123 = this.f521244k;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (((((r122 + r124) * 31) + this.f521245l.hashCode()) * 31) + this.f521246m.hashCode()) * 31;
        Integer r126 = this.f521247n;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        Image r129 = this.f521248o;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        ResourceUploadInstantInfo r132 = this.f521249p;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f521250q;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f521251r;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (((r137 + r139) * 31) + this.f521252s.hashCode()) * 31;
        if (this.f521253t == false) goto L61;
        int r141 = 1231;
    L62:
        int r142 = (r140 + r141) * 31;
        if (this.f521254u == false) goto L65;
        int r143 = 1231;
    L66:
        int r144 = (r142 + r143) * 31;
        zs8.a r145 = this.f521255v;
        if (r145 != null) goto L69;
        int r146 = 0;
    L70:
        int r147 = (r144 + r146) * 31;
        by7.e r148 = this.f521256w;
        if (r148 != null) goto L73;
        int r149 = 0;
    L74:
        int r150 = (r147 + r149) * 31;
        Bundle r151 = this.f521257x;
        if (r151 != null) goto L77;
        int r152 = 0;
    L78:
        int r153 = (r150 + r152) * 31;
        if (this.f521258y == false) goto L81;
        int r154 = 1231;
    L82:
        int r155 = (r153 + r154) * 31;
        Map<String, String> r156 = this.f521259z;
        if (r156 != null) goto L85;
        int r157 = 0;
    L86:
        int r158 = (r155 + r157) * 31;
        Integer r159 = this.A;
        if (r159 != null) goto L89;
        int r160 = 0;
    L90:
        int r161 = (r158 + r160) * 31;
        Integer r162 = this.B;
        if (r162 != null) goto L93;
        int r163 = 0;
    L94:
        int r164 = (r161 + r163) * 31;
        if (this.C == false) goto L97;
        int r165 = 1231;
    L98:
        int r166 = (r164 + r165) * 31;
        CustomInputInitData r167 = this.D;
        if (r167 != null) goto L101;
        int r168 = 0;
    L102:
        int r169 = (r166 + r168) * 31;
        if (this.E == false) goto L105;
        int r170 = 1231;
    L106:
        int r171 = (r169 + r170) * 31;
        Boolean r172 = this.F;
        if (r172 != null) goto L109;
        int r173 = 0;
    L110:
        int r174 = (r171 + r173) * 31;
        Boolean r175 = this.G;
        if (r175 != null) goto L113;
        int r176 = 0;
    L114:
        int r177 = (r174 + r176) * 31;
        Boolean r178 = this.H;
        if (r178 != null) goto L117;
        int r179 = 0;
    L118:
        int r180 = (r177 + r179) * 31;
        Boolean r181 = this.I;
        if (r181 != null) goto L121;
        int r182 = 0;
    L122:
        int r183 = (r180 + r182) * 31;
        Boolean r184 = this.f521233J;
        if (r184 != null) goto L125;
        int r185 = 0;
    L126:
        int r186 = (r183 + r185) * 31;
        String r187 = this.K;
        if (r187 != null) goto L129;
        int r188 = 0;
    L130:
        int r189 = (r186 + r188) * 31;
        String r190 = this.L;
        if (r190 != null) goto L133;
        int r191 = 0;
    L134:
        int r192 = (r189 + r191) * 31;
        lr9.a r193 = this.M;
        if (r193 != null) goto L137;
        int r194 = 0;
    L138:
        int r195 = (r192 + r194) * 31;
        String r196 = this.N;
        if (r196 != null) goto L141;
        int r197 = 0;
    L142:
        int r198 = (r195 + r197) * 31;
        String r199 = this.O;
        if (r199 != null) goto L145;
        int r200 = 0;
    L146:
        int r201 = (r198 + r200) * 31;
        Boolean r202 = this.P;
        if (r202 != null) goto L149;
        int r203 = 0;
    L150:
        int r204 = (r201 + r203) * 31;
        Integer r205 = this.Q;
        if (r205 != null) goto L153;
        int r206 = 0;
    L154:
        int r207 = (r204 + r206) * 31;
        Boolean r208 = this.R;
        if (r208 != null) goto L157;
        int r209 = 0;
    L158:
        int r210 = (r207 + r209) * 31;
        ChatPageContext r211 = this.S;
        if (r211 != null) goto L161;
        int r212 = 0;
    L162:
        int r213 = (r210 + r212) * 31;
        Fragment r214 = this.T;
        if (r214 != null) goto L165;
        int r215 = 0;
    L166:
        int r216 = (r213 + r215) * 31;
        Fragment r217 = this.U;
        if (r217 != null) goto L169;
        int r218 = 0;
    L170:
        int r219 = (r216 + r218) * 31;
        CreationDoSameNotifyInfo r220 = this.V;
        if (r220 != null) goto L173;
        int r221 = 0;
    L174:
        int r222 = (r219 + r221) * 31;
        String r223 = this.W;
        if (r223 == null) goto L178;
        r104 = r223.hashCode();
    L178:
        int r224 = (r222 + r104) * 31;
        if (this.X == true) goto L183;
        r100 = 1237;
    L183:
        return r224 + r100;
    L173:
        r221 = r220.hashCode();
        goto L174
    L169:
        r218 = r217.hashCode();
        goto L170
    L165:
        r215 = r214.hashCode();
        goto L166
    L161:
        r212 = r211.hashCode();
        goto L162
    L157:
        r209 = r208.hashCode();
        goto L158
    L153:
        r206 = r205.hashCode();
        goto L154
    L149:
        r203 = r202.hashCode();
        goto L150
    L145:
        r200 = r199.hashCode();
        goto L146
    L141:
        r197 = r196.hashCode();
        goto L142
    L137:
        r194 = r193.hashCode();
        goto L138
    L133:
        r191 = r190.hashCode();
        goto L134
    L129:
        r188 = r187.hashCode();
        goto L130
    L125:
        r185 = r184.hashCode();
        goto L126
    L121:
        r182 = r181.hashCode();
        goto L122
    L117:
        r179 = r178.hashCode();
        goto L118
    L113:
        r176 = r175.hashCode();
        goto L114
    L109:
        r173 = r172.hashCode();
        goto L110
    L105:
        r170 = 1237;
        goto L106
    L101:
        r168 = r167.hashCode();
        goto L102
    L97:
        r165 = 1237;
        goto L98
    L93:
        r163 = r162.hashCode();
        goto L94
    L89:
        r160 = r159.hashCode();
        goto L90
    L85:
        r157 = r156.hashCode();
        goto L86
    L81:
        r154 = 1237;
        goto L82
    L77:
        r152 = r151.hashCode();
        goto L78
    L73:
        r149 = r148.hashCode();
        goto L74
    L69:
        r146 = r145.hashCode();
        goto L70
    L65:
        r143 = 1237;
        goto L66
    L61:
        r141 = 1237;
        goto L62
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreatePageConfig(isHalfScreenPage=" + this.f521234a + ", activity=" + this.f521235b + ", item=" + this.f521236c + ", chatParam=" + this.f521237d + ", openNewChatPageOnSend=" + this.f521238e + ", openNewChatPageOnSendWithClearTop=" + this.f521239f + ", template=" + this.f521240g + ", userPrompt=" + this.f521241h + ", refImageUrl=" + this.f521242i + ", refRawImageUrl=" + this.f521243j + ", refCreateRefInfoList=" + this.f521244k + ", avatarImageUrlList=" + this.f521245l + ", whiteTeeIndexList=" + this.f521246m + ", selectInstructionType=" + this.f521247n + ", refImage=" + this.f521248o + ", refImageInstantUploadInfo=" + this.f521249p + ", refImageLocalMessageId=" + this.f521250q + ", refImageAlbumPath=" + this.f521251r + ", refImageAlbumPathList=" + this.f521252s + ", isAiCreation=" + this.f521253t + ", isReedit=" + this.f521254u + ", hitPointData=" + this.f521255v + ", trackNode=" + this.f521256w + ", extraBundle=" + this.f521257x + ", cleaInput=" + this.f521258y + ", msgExtMap=" + this.f521259z + ", selectStartPosition=" + this.A + ", selectEndPosition=" + this.B + ", isEnterTemplate=" + this.C + ", customInputInitData=" + this.D + ", ignoreSideBar=" + this.E + ", isFromChatDoublePage=" + this.F + ", isShowReselect=" + this.G + ", isPrivateImage=" + this.H + ", isNoImeWhenInit=" + this.I + ", needFinishCurrentCreatePage=" + this.f521233J + ", previousPageName=" + this.K + ", defaultLandingTabId=" + this.L + ", slidesMobConfig=" + this.M + ", queryImageRatio=" + this.N + ", openFrom=" + this.O + ", avatarCreateFormat=" + this.P + ", doSameLandingType=" + this.Q + ", isSendFromDetail=" + this.R + ", chatPageContext=" + this.S + ", fragment=" + this.T + ", compactForsetiFragment=" + this.U + ", creationDoSameNotifyInfo=" + this.V + ", chatSectionId=" + this.W + ", allowAppletWhenHalfScreen=" + this.X + ')';
    }

    public b(boolean r410, Activity r510, z0 r511, ChatParam r512, boolean r513, boolean r514, String r515, String r516, String r517, String r518, List r519, List r610, List r611, Integer r612, Image r613, ResourceUploadInstantInfo r614, String r615, String r616, List r617, boolean r618, boolean r619, zs8.a r710, by7.e r711, Bundle r712, boolean r713, Map r714, Integer r715, Integer r716, boolean r717, CustomInputInitData r718, boolean r719, Boolean r810, Boolean r811, Boolean r812, Boolean r813, Boolean r814, String r815, String r816, lr9.a r817, String r818, String r819, Boolean r910, Integer r911, Boolean r912, ChatPageContext r913, Fragment r914, Fragment r915, CreationDoSameNotifyInfo r916, String r917, boolean r918, int r919, int r100) {
        if ((r919 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r919 & 16) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r919 & 32) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r919 & 64) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r919 & 128) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r919 & 256) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r919 & 512) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r919 & 1024) == 0) goto L33;
        List r113 = new ArrayList();
    L35:
        if ((r919 & 2048) == 0) goto L37;
        List r114 = new ArrayList();
    L39:
        if ((r919 & 4096) == 0) goto L41;
        List r105 = new ArrayList();
    L43:
        if ((r919 & 8192) == 0) goto L45;
        Integer r115 = null;
    L46:
        Integer r520 = r115;
        if ((r919 & 16384) == 0) goto L49;
        Image r116 = null;
    L51:
        if ((r919 & 32768) == 0) goto L53;
        ResourceUploadInstantInfo r117 = null;
    L55:
        if ((r919 & 65536) == 0) goto L57;
        String r210 = null;
    L59:
        if ((r919 & 131072) == 0) goto L61;
        String r211 = null;
    L63:
        if ((r919 & 262144) == 0) goto L65;
        List r118 = new ArrayList();
    L67:
        if ((r919 & 524288) == 0) goto L69;
        boolean r212 = false;
    L71:
        if ((r919 & 1048576) == 0) goto L73;
        boolean r213 = false;
    L75:
        if ((r919 & 2097152) == 0) goto L77;
        zs8.a r214 = null;
    L79:
        if ((r919 & 4194304) == 0) goto L81;
        by7.e r215 = null;
    L83:
        if ((r919 & 8388608) == 0) goto L85;
        Bundle r216 = null;
    L87:
        if ((r919 & 16777216) == 0) goto L89;
        boolean r310 = false;
    L91:
        if ((r919 & 33554432) == 0) goto L93;
        Map r311 = null;
    L95:
        if ((r919 & 67108864) == 0) goto L97;
        Integer r312 = null;
    L99:
        if ((r919 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L101;
        Integer r313 = null;
    L103:
        if ((r919 & 268435456) == 0) goto L105;
        boolean r314 = true;
    L107:
        if ((r919 & 536870912) == 0) goto L109;
        CustomInputInitData r315 = null;
    L111:
        if ((r919 & 1073741824) == 0) goto L113;
        boolean r316 = false;
    L115:
        if ((r919 & Integer.MIN_VALUE) == 0) goto L117;
        Boolean r106 = Boolean.FALSE;
    L119:
        if ((r100 & 1) == 0) goto L121;
        Boolean r317 = Boolean.FALSE;
    L123:
        if ((r100 & 2) == 0) goto L125;
        Boolean r318 = Boolean.FALSE;
    L127:
        if ((r100 & 4) == 0) goto L129;
        Boolean r319 = Boolean.FALSE;
    L131:
        if ((r100 & 8) == 0) goto L133;
        Boolean r411 = Boolean.FALSE;
    L135:
        if ((r100 & 16) == 0) goto L137;
        String r412 = null;
    L139:
        if ((r100 & 32) == 0) goto L141;
        String r413 = null;
    L143:
        if ((r100 & 64) == 0) goto L145;
        lr9.a r414 = null;
    L146:
        Boolean r217 = r106;
        if ((r100 & 128) == 0) goto L149;
        String r107 = "";
    L150:
        String r521 = r107;
        if ((r100 & 256) == 0) goto L153;
        String r108 = "";
    L154:
        String r415 = r108;
        if ((r100 & 512) == 0) goto L157;
        Boolean r109 = null;
    L158:
        Boolean r522 = r109;
        if ((r100 & 1024) == 0) goto L161;
        Integer r119 = null;
    L162:
        Integer r523 = r119;
        if ((r100 & 2048) == 0) goto L165;
        Boolean r120 = Boolean.FALSE;
    L166:
        Boolean r524 = r120;
        if ((r100 & 4096) == 0) goto L169;
        ChatPageContext r121 = null;
    L170:
        ChatPageContext r525 = r121;
        if ((r100 & 8192) == 0) goto L173;
        Fragment r122 = null;
    L174:
        Fragment r526 = r122;
        if ((r100 & 16384) == 0) goto L177;
        Fragment r123 = null;
    L179:
        if ((r100 & 32768) == 0) goto L181;
        CreationDoSameNotifyInfo r416 = null;
    L183:
        if ((r100 & 65536) == 0) goto L185;
        String r417 = null;
    L187:
        if ((r100 & 131072) == 0) goto L189;
        boolean r124 = false;
    L190:
        Intrinsics.checkNotNullParameter(r510, "activity");
        Intrinsics.checkNotNullParameter(r511, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r114, "avatarImageUrlList");
        Intrinsics.checkNotNullParameter(r105, "whiteTeeIndexList");
        Intrinsics.checkNotNullParameter(r118, "refImageAlbumPathList");
        this.f521234a = r101;
        this.f521235b = r510;
        this.f521236c = r511;
        this.f521237d = r512;
        this.f521238e = r102;
        this.f521239f = r103;
        this.f521240g = r104;
        this.f521241h = r110;
        this.f521242i = r111;
        this.f521243j = r112;
        this.f521244k = r113;
        this.f521245l = r114;
        this.f521246m = r105;
        this.f521247n = r520;
        this.f521248o = r116;
        this.f521249p = r117;
        this.f521250q = r210;
        this.f521251r = r211;
        this.f521252s = r118;
        this.f521253t = r212;
        this.f521254u = r213;
        this.f521255v = r214;
        this.f521256w = r215;
        this.f521257x = r216;
        this.f521258y = r310;
        this.f521259z = r311;
        this.A = r312;
        this.B = r313;
        this.C = r314;
        this.D = r315;
        this.E = r316;
        this.F = r217;
        this.G = r317;
        this.H = r318;
        this.I = r319;
        this.f521233J = r411;
        this.K = r412;
        this.L = r413;
        this.M = r414;
        this.N = r521;
        this.O = r415;
        this.P = r522;
        this.Q = r523;
        this.R = r524;
        this.S = r525;
        this.T = r526;
        this.U = r123;
        this.V = r416;
        this.W = r417;
        this.X = r124;
        return;
    L189:
        r124 = r918;
        goto L190
    L185:
        r417 = r917;
        goto L187
    L181:
        r416 = r916;
        goto L183
    L177:
        r123 = r915;
        goto L179
    L173:
        r122 = r914;
        goto L174
    L169:
        r121 = r913;
        goto L170
    L165:
        r120 = r912;
        goto L166
    L161:
        r119 = r911;
        goto L162
    L157:
        r109 = r910;
        goto L158
    L153:
        r108 = r819;
        goto L154
    L149:
        r107 = r818;
        goto L150
    L145:
        r414 = r817;
        goto L146
    L141:
        r413 = r816;
        goto L143
    L137:
        r412 = r815;
        goto L139
    L133:
        r411 = r814;
        goto L135
    L129:
        r319 = r813;
        goto L131
    L125:
        r318 = r812;
        goto L127
    L121:
        r317 = r811;
        goto L123
    L117:
        r106 = r810;
        goto L119
    L113:
        r316 = r719;
        goto L115
    L109:
        r315 = r718;
        goto L111
    L105:
        r314 = r717;
        goto L107
    L101:
        r313 = r716;
        goto L103
    L97:
        r312 = r715;
        goto L99
    L93:
        r311 = r714;
        goto L95
    L89:
        r310 = r713;
        goto L91
    L85:
        r216 = r712;
        goto L87
    L81:
        r215 = r711;
        goto L83
    L77:
        r214 = r710;
        goto L79
    L73:
        r213 = r619;
        goto L75
    L69:
        r212 = r618;
        goto L71
    L65:
        r118 = r617;
        goto L67
    L61:
        r211 = r616;
        goto L63
    L57:
        r210 = r615;
        goto L59
    L53:
        r117 = r614;
        goto L55
    L49:
        r116 = r613;
        goto L51
    L45:
        r115 = r612;
        goto L46
    L41:
        r105 = r611;
        goto L43
    L37:
        r114 = r610;
        goto L39
    L33:
        r113 = r519;
        goto L35
    L29:
        r112 = r518;
        goto L31
    L25:
        r111 = r517;
        goto L27
    L21:
        r110 = r516;
        goto L23
    L17:
        r104 = r515;
        goto L19
    L13:
        r103 = r514;
        goto L15
    L9:
        r102 = r513;
        goto L11
    L5:
        r101 = r410;
        goto L7
    }
}
