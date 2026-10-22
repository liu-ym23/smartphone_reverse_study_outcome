package r41;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0003\b¢\u0001\u0018\u00002\u00020\u0001:\u00014B\t¢\u0006\u0006\b¢\u0001\u0010£\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR$\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR$\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR$\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0004\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR$\u0010W\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR$\u0010Z\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR$\u0010]\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR$\u0010`\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR$\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR$\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR$\u0010i\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR$\u0010l\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010\u0004\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR$\u0010o\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010\u0004\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR$\u0010r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR$\u0010u\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0004\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR$\u0010x\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010\u0004\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR$\u0010{\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010\u0004\u001a\u0004\b|\u0010\u0006\"\u0004\b}\u0010\bR%\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010\u0004\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0004\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR(\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR(\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR(\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\u0004\u001a\u0005\b\u0091\u0001\u0010\u0006\"\u0005\b\u0092\u0001\u0010\bR(\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR(\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR(\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR(\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u0004\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\bR(\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0004\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\b¨\u0006¤\u0001"}, d2 = {"Lr41/d;", "", "", "pkFailIcon", "Ljava/lang/String;", "getPkFailIcon", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "pkVictoryIcon", "getPkVictoryIcon", "w", "pkTieIcon", "getPkTieIcon", "r", "pkTitleBarTextColor", "getPkTitleBarTextColor", "t", "pkTitleBarWidth", "getPkTitleBarWidth", "u", "pkTitleBarBg", "getPkTitleBarBg", "s", "pkTitleIcon", "getPkTitleIcon", "setPkTitleIcon", "scoreBarLeftStartColor", "getScoreBarLeftStartColor", "y", "scoreBarLeftEndColor", "getScoreBarLeftEndColor", "x", "scoreBarRightStartColor", "getScoreBarRightStartColor", "B", "scoreBarRightEndColor", "getScoreBarRightEndColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "scoreBarLeftTextColor", "getScoreBarLeftTextColor", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "scoreBarRightTextColor", "getScoreBarRightTextColor", "C", "pkBg", "getPkBg", ce.f26396k, "pkBgUp", "b", "m", "pkBgDown", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "l", "pkStartAnimation", "getPkStartAnimation", "p", "pkVictoryAnimation", "getPkVictoryAnimation", BaseSwitches.V, "pkFailAnimation", "getPkFailAnimation", OfficeSDKRequestTag.KEY_NEW_USER, "pkTieAnimation", "getPkTieAnimation", "q", "pkPanelRandomBg", "getPkPanelRandomBg", "setPkPanelRandomBg", "pkPanelButtonBg", "getPkPanelButtonBg", "setPkPanelButtonBg", "pkPanelBarBg", "getPkPanelBarBg", "setPkPanelBarBg", "barTextColor", "getBarTextColor", "setBarTextColor", "randomPkButtonBg", "getRandomPkButtonBg", "setRandomPkButtonBg", "randomPkButtonTextColor", "getRandomPkButtonTextColor", "setRandomPkButtonTextColor", "resultTextBg", "getResultTextBg", "setResultTextBg", "startAnimLeftBg", "getStartAnimLeftBg", "setStartAnimLeftBg", "startAnimRightBg", "getStartAnimRightBg", "setStartAnimRightBg", "startAnimLeftTextColor", "getStartAnimLeftTextColor", "setStartAnimLeftTextColor", "startAnimRightTextColor", "getStartAnimRightTextColor", "setStartAnimRightTextColor", "pkResultConsecutiveVictoryBronze", "getPkResultConsecutiveVictoryBronze", "setPkResultConsecutiveVictoryBronze", "pkResultConsecutiveVictorySilver", "getPkResultConsecutiveVictorySilver", "setPkResultConsecutiveVictorySilver", "pkResultConsecutiveVictoryGold", "getPkResultConsecutiveVictoryGold", "setPkResultConsecutiveVictoryGold", "pkResultConsecutiveVictoryPlatinum", "getPkResultConsecutiveVictoryPlatinum", "setPkResultConsecutiveVictoryPlatinum", "pkResultConsecutiveVictoryDiamond", "getPkResultConsecutiveVictoryDiamond", "setPkResultConsecutiveVictoryDiamond", "pkRecordResultIconVictory", ce.f26395j, "setPkRecordResultIconVictory", "pkRecordResultIconDraw", "h", "setPkRecordResultIconDraw", "pkRecordResultIconFailure", RXScreenCaptureService.KEY_INDEX, "setPkRecordResultIconFailure", "pkRecordEmptyPanelAutomatchBtnBg", "getPkRecordEmptyPanelAutomatchBtnBg", "setPkRecordEmptyPanelAutomatchBtnBg", "pkRecordEmptyPanelAutomatchBtnTextColor", "getPkRecordEmptyPanelAutomatchBtnTextColor", "setPkRecordEmptyPanelAutomatchBtnTextColor", "pkRecordOncemoreBtnBg", "f", "setPkRecordOncemoreBtnBg", "pkRecordOncemoreBtnTextColor", ce.f26391f, "setPkRecordOncemoreBtnTextColor", "pkRecordConsecutiveVictoryBg", "c", "setPkRecordConsecutiveVictoryBg", "pkRecordConsecutiveVictoryText", "d", "setPkRecordConsecutiveVictoryText", "pkRecordConsecutiveVictoryTextColor", "e", "setPkRecordConsecutiveVictoryTextColor", "pkRankSeasonTitleImage", "getPkRankSeasonTitleImage", "setPkRankSeasonTitleImage", "pkRankSeasonEventBg", "getPkRankSeasonEventBg", "setPkRankSeasonEventBg", "pkRankSeasonUpResultBg", "getPkRankSeasonUpResultBg", "setPkRankSeasonUpResultBg", "pkRankSeasonUpResultAnimBg", "getPkRankSeasonUpResultAnimBg", "setPkRankSeasonUpResultAnimBg", "pkRankSeasonDrawResultBg", "getPkRankSeasonDrawResultBg", "setPkRankSeasonDrawResultBg", "pkRankSeasonDownResultBg", "getPkRankSeasonDownResultBg", "setPkRankSeasonDownResultBg", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f536018a = 0;

    @SerializedName("panel_random_info_text_color")
    private String barTextColor;

    @SerializedName("pk_bg")
    private String pkBg;

    @SerializedName("pk_bg_down")
    private String pkBgDown;

    @SerializedName("pk_bg_up")
    private String pkBgUp;

    @SerializedName("fail_animation")
    private String pkFailAnimation;

    @SerializedName("pk_fail_icon")
    private String pkFailIcon;

    @SerializedName("panel_banner_info_bg")
    private String pkPanelBarBg;

    @SerializedName("panel_invite_button_bg")
    private String pkPanelButtonBg;

    @SerializedName("panel_random_bg")
    private String pkPanelRandomBg;

    @SerializedName("pk_rank_season_down_result_bg")
    private String pkRankSeasonDownResultBg;

    @SerializedName("pk_rank_season_draw_result_bg")
    private String pkRankSeasonDrawResultBg;

    @SerializedName("pk_rank_season_event_bg")
    private String pkRankSeasonEventBg;

    @SerializedName("pk_rank_season_title_image")
    private String pkRankSeasonTitleImage;

    @SerializedName("pk_rank_season_up_result_anim_bg")
    private String pkRankSeasonUpResultAnimBg;

    @SerializedName("pk_rank_season_up_result_bg")
    private String pkRankSeasonUpResultBg;

    @SerializedName("pk_record_consecutiveWin_bg")
    private String pkRecordConsecutiveVictoryBg;

    @SerializedName("pk_record_consecutiveWin_text")
    private String pkRecordConsecutiveVictoryText;

    @SerializedName("pk_record_consecutiveWin_text_color")
    private String pkRecordConsecutiveVictoryTextColor;

    @SerializedName("pk_empty_record_panel_automatch_button_bg")
    private String pkRecordEmptyPanelAutomatchBtnBg;

    @SerializedName("pk_empty_record_panel_automatch_button_textcolor")
    private String pkRecordEmptyPanelAutomatchBtnTextColor;

    @SerializedName("pk_record_cell_onemore_button_bg")
    private String pkRecordOncemoreBtnBg;

    @SerializedName("pk_record_cell_onemore_button_textcolor")
    private String pkRecordOncemoreBtnTextColor;

    @SerializedName("live_pk_record_cell_deuce")
    private String pkRecordResultIconDraw;

    @SerializedName("live_pk_record_cell_defeat")
    private String pkRecordResultIconFailure;

    @SerializedName("live_pk_record_cell_victory")
    private String pkRecordResultIconVictory;

    @SerializedName("live_pk_succession_victory_bronze")
    private String pkResultConsecutiveVictoryBronze;

    @SerializedName("live_pk_succession_victory_diamond")
    private String pkResultConsecutiveVictoryDiamond;

    @SerializedName("live_pk_succession_victory_gold")
    private String pkResultConsecutiveVictoryGold;

    @SerializedName("live_pk_succession_victory_platinum")
    private String pkResultConsecutiveVictoryPlatinum;

    @SerializedName("live_pk_succession_victory_silver")
    private String pkResultConsecutiveVictorySilver;

    @SerializedName("start_animation")
    private String pkStartAnimation;

    @SerializedName("tie_animation")
    private String pkTieAnimation;

    @SerializedName("pk_tie_icon")
    private String pkTieIcon;

    @SerializedName("pk_title_bar_bg")
    private String pkTitleBarBg;

    @SerializedName("pk_title_bar_text_color")
    private String pkTitleBarTextColor;

    @SerializedName("pk_title_bar_width")
    private String pkTitleBarWidth;

    @SerializedName("pk_logo")
    private String pkTitleIcon;

    @SerializedName("victory_animation")
    private String pkVictoryAnimation;

    @SerializedName("pk_victory_icon")
    private String pkVictoryIcon;

    @SerializedName("panel_random_button_bg")
    private String randomPkButtonBg;

    @SerializedName("panel_random_button_text_color")
    private String randomPkButtonTextColor;

    @SerializedName("result_animation_text_bg")
    private String resultTextBg;

    @SerializedName("score_bar_left_end_color")
    private String scoreBarLeftEndColor;

    @SerializedName("score_bar_left_start_color")
    private String scoreBarLeftStartColor;

    @SerializedName("score_bar_left_text_color")
    private String scoreBarLeftTextColor;

    @SerializedName("score_bar_right_end_color")
    private String scoreBarRightEndColor;

    @SerializedName("score_bar_right_start_color")
    private String scoreBarRightStartColor;

    @SerializedName("score_bar_right_text_color")
    private String scoreBarRightTextColor;

    @SerializedName("self_start_animation_info_bg")
    private String startAnimLeftBg;

    @SerializedName("self_start_animation_info_text_color")
    private String startAnimLeftTextColor;

    @SerializedName("oppo_start_animation_info_bg")
    private String startAnimRightBg;

    @SerializedName("oppo_start_animation_info_text_color")
    private String startAnimRightTextColor;

    public static final class a {
        public static HashMap a() {
            d r100 = new d();
            r100.o();
            r100.w();
            r100.r();
            r100.t();
            r100.u();
            r100.s();
            r100.y();
            r100.x();
            r100.B();
            r100.A();
            r100.z();
            r100.C();
            r100.k();
            r100.m();
            r100.l();
            r100.p();
            r100.v();
            r100.n();
            r100.q();
            return new HashMap();
        }
    }

    static {
    }

    public final void A() {
        Intrinsics.checkNotNullParameter("#579CFF", "<set-?>");
        this.scoreBarRightEndColor = "#579CFF";
    }

    public final void B() {
        Intrinsics.checkNotNullParameter("#71EEFF", "<set-?>");
        this.scoreBarRightStartColor = "#71EEFF";
    }

    public final void C() {
        Intrinsics.checkNotNullParameter("#0A2876", "<set-?>");
        this.scoreBarRightTextColor = "#0A2876";
    }

    public final void k() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg.png", "<set-?>");
        this.pkBg = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg.png";
    }

    public final void l() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_down.png", "<set-?>");
        this.pkBgDown = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_down.png";
    }

    public final void m() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_up.png", "<set-?>");
        this.pkBgUp = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_bg_up.png";
    }

    public final void n() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_fail_animation.webp", "<set-?>");
        this.pkFailAnimation = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_fail_animation.webp";
    }

    public final void o() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_fail_icon_1.png", "<set-?>");
        this.pkFailIcon = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_fail_icon_1.png";
    }

    public final void p() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_start_animation.webp", "<set-?>");
        this.pkStartAnimation = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_start_animation.webp";
    }

    public final void q() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_tie_animation.webp", "<set-?>");
        this.pkTieAnimation = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_tie_animation.webp";
    }

    public final void r() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_hourly_rank_tie_icon_1.png", "<set-?>");
        this.pkTieIcon = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_hourly_rank_tie_icon_1.png";
    }

    public final void s() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_title_bar_bg.png", "<set-?>");
        this.pkTitleBarBg = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_title_bar_bg.png";
    }

    public final void t() {
        Intrinsics.checkNotNullParameter("#8C5906", "<set-?>");
        this.pkTitleBarTextColor = "#8C5906";
    }

    public final void u() {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_BPEA_WITHOUT_CERT, "<set-?>");
        this.pkTitleBarWidth = BDLocationException.ERROR_BPEA_WITHOUT_CERT;
    }

    public final void v() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_victory_animation.webp", "<set-?>");
        this.pkVictoryAnimation = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/douyin_hourly_rank_victory_animation.webp";
    }

    public final void w() {
        Intrinsics.checkNotNullParameter("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_victory_icon_1.png", "<set-?>");
        this.pkVictoryIcon = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-ios-ackage/pk_houly_rank_victory_icon_1.png";
    }

    public final void x() {
        Intrinsics.checkNotNullParameter("#FFD687", "<set-?>");
        this.scoreBarLeftEndColor = "#FFD687";
    }

    public final void y() {
        Intrinsics.checkNotNullParameter("#FFAB2D", "<set-?>");
        this.scoreBarLeftStartColor = "#FFAB2D";
    }

    public final void z() {
        Intrinsics.checkNotNullParameter("#520137", "<set-?>");
        this.scoreBarLeftTextColor = "#520137";
    }

    public d() {
        this.pkFailIcon = "";
        this.pkVictoryIcon = "";
        this.pkTieIcon = "";
        this.pkTitleBarTextColor = "";
        this.pkTitleBarWidth = "";
        this.pkTitleBarBg = "";
        this.pkTitleIcon = "";
        this.scoreBarLeftStartColor = "";
        this.scoreBarLeftEndColor = "";
        this.scoreBarRightStartColor = "";
        this.scoreBarRightEndColor = "";
        this.scoreBarLeftTextColor = "";
        this.scoreBarRightTextColor = "";
        this.pkBg = "";
        this.pkBgUp = "";
        this.pkBgDown = "";
        this.pkStartAnimation = "";
        this.pkVictoryAnimation = "";
        this.pkFailAnimation = "";
        this.pkTieAnimation = "";
    }

    public final String a() {
        return this.pkBgDown;
    }

    public final String b() {
        return this.pkBgUp;
    }

    public final String c() {
        return this.pkRecordConsecutiveVictoryBg;
    }

    public final String d() {
        return this.pkRecordConsecutiveVictoryText;
    }

    public final String e() {
        return this.pkRecordConsecutiveVictoryTextColor;
    }

    public final String f() {
        return this.pkRecordOncemoreBtnBg;
    }

    public final String g() {
        return this.pkRecordOncemoreBtnTextColor;
    }

    public final String h() {
        return this.pkRecordResultIconDraw;
    }

    public final String i() {
        return this.pkRecordResultIconFailure;
    }

    public final String j() {
        return this.pkRecordResultIconVictory;
    }
}
