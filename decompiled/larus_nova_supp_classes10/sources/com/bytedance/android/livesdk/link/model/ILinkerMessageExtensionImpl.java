package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent;
import com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkRoomFightReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLiveCoreBizTagChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLowBalanceForPaidLinkmicContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAudienceWaitingListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAvatarAuditContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInitChatRoomContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0092\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010¢\u0002\u001a\u00020\u0002¢\u0006\u0006\b£\u0002\u0010¤\u0002J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u0004\u0018\u00010>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u0004\u0018\u00010B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u0004\u0018\u00010F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u0004\u0018\u00010J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010T\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0016\u0010X\u001a\u0004\u0018\u00010U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR(\u0010_\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010c\u001a\u0004\u0018\u00010`8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010g\u001a\u0004\u0018\u00010d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u0010fR\u0016\u0010k\u001a\u0004\u0018\u00010h8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0016\u0010s\u001a\u0004\u0018\u00010p8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0016\u0010u\u001a\u0004\u0018\u00010U8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bt\u0010WR\u0014\u0010y\u001a\u00020v8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0016\u0010}\u001a\u0004\u0018\u00010z8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R$\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R$\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010§\u0001\u001a\u0005\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\"\u0010«\u0001\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0096\u000f¢\u0006\u000f\u001a\u0005\b¨\u0001\u0010@\"\u0006\b©\u0001\u0010ª\u0001R\u001a\u0010¯\u0001\u001a\u0005\u0018\u00010¬\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001a\u0010³\u0001\u001a\u0005\u0018\u00010°\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u001a\u0010·\u0001\u001a\u0005\u0018\u00010´\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010»\u0001\u001a\u00030¸\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¿\u0001\u001a\u0005\u0018\u00010¼\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b½\u0001\u0010¾\u0001R\u0016\u0010Á\u0001\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010SR\u001a\u0010Å\u0001\u001a\u0005\u0018\u00010Â\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u001a\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R$\u0010Ï\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R\u001a\u0010Ó\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010×\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u001a\u0010Û\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u001a\u0010ß\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010ã\u0001\u001a\u0005\u0018\u00010à\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bá\u0001\u0010â\u0001R\u001a\u0010ç\u0001\u001a\u0005\u0018\u00010ä\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u0005\u0018\u00010è\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010ï\u0001\u001a\u0005\u0018\u00010ì\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ó\u0001\u001a\u0005\u0018\u00010ð\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001R\u0018\u0010÷\u0001\u001a\u00030ô\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bõ\u0001\u0010ö\u0001R\u0018\u0010û\u0001\u001a\u00030ø\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bù\u0001\u0010ú\u0001R\u001a\u0010ÿ\u0001\u001a\u0005\u0018\u00010ü\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u0016\u0010\u0081\u0002\u001a\u00020v8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0080\u0002\u0010xR\u001a\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0016\u0010\u0087\u0002\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0086\u0002\u0010SR\u0019\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002R\u001a\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0016\u0010\u0090\u0002\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b\u008f\u0002\u0010SR\u0016\u0010\u0092\u0002\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0091\u0002\u0010SR\u001b\u0010\u0095\u0002\u001a\u00070\rj\u0003`\u0093\u00028\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b\u0094\u0002\u0010SR\u001a\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0096\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u001a\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009a\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001a\u0010¡\u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009f\u0002\u0010 \u0002¨\u0006¥\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "Lcom/bytedance/android/livesdk/link/model/i6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getOrInitPublicAreaCommon", "", "ntpDiff", "getReceiveNtpTimeFlex", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInMessage", "Lcom/bytedance/android/livesdk/link/model/h6;", "getLinkedListChange", "()Lcom/bytedance/android/livesdk/link/model/h6;", "linkedListChange", "Lcom/bytedance/android/livesdk/link/model/r6;", "getWaitingListChange", "()Lcom/bytedance/android/livesdk/link/model/r6;", "waitingListChange", "Lcom/bytedance/android/livesdk/link/model/x5;", "getCancel", "()Lcom/bytedance/android/livesdk/link/model/x5;", "cancel", "Lcom/bytedance/android/livesdk/link/model/e6;", "getInvite", "()Lcom/bytedance/android/livesdk/link/model/e6;", "invite", "Lcom/bytedance/android/livesdk/link/model/k6;", "getReply", "()Lcom/bytedance/android/livesdk/link/model/k6;", "reply", "Lcom/bytedance/android/livesdk/link/model/c4;", "getCrossRoomRTCInfoContent", "()Lcom/bytedance/android/livesdk/link/model/c4;", "crossRoomRTCInfoContent", "Lcom/bytedance/android/livesdk/link/model/q6;", "getSwitchSceneContent", "()Lcom/bytedance/android/livesdk/link/model/q6;", "switchSceneContent", "Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "getClose", "()Lcom/bytedance/android/livesdk/link/model/ILinkerCloseContent;", "close", "Lcom/bytedance/android/livesdk/link/model/w5;", "getLinkerBanContent", "()Lcom/bytedance/android/livesdk/link/model/w5;", "linkerBanContent", "Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent;", "getAnchorUpdateLayoutContent", "()Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent;", "anchorUpdateLayoutContent", "Lcom/bytedance/android/livesdk/link/model/y5;", "getLinkerChangeMultiPkTeamInfoContent", "()Lcom/bytedance/android/livesdk/link/model/y5;", "linkerChangeMultiPkTeamInfoContent", "Lcom/bytedance/android/live/base/model/data/i;", "getLinkerCrossRoomUpdateContent", "()Lcom/bytedance/android/live/base/model/data/i;", "linkerCrossRoomUpdateContent", "Lcom/bytedance/android/livesdk/link/model/x;", "getAnchorUpdateLinkMicConfigContent", "()Lcom/bytedance/android/livesdk/link/model/x;", "anchorUpdateLinkMicConfigContent", "Lcom/bytedance/android/livesdk/link/model/o6;", "getSwitchChannelInviteContent", "()Lcom/bytedance/android/livesdk/link/model/o6;", "switchChannelInviteContent", "Lcom/bytedance/android/livesdk/link/model/p6;", "getSwitchChannelReplyContent", "()Lcom/bytedance/android/livesdk/link/model/p6;", "switchChannelReplyContent", "Lcom/bytedance/android/livesdk/link/model/n6;", "getSwitchChannelCancelContent", "()Lcom/bytedance/android/livesdk/link/model/n6;", "switchChannelCancelContent", "getVersion", "()J", "version", "", "getLynxData", "()Ljava/lang/String;", "lynxData", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "Lcom/bytedance/android/livesdk/link/model/u5;", "getAnchorStreamSwitchContent", "()Lcom/bytedance/android/livesdk/link/model/u5;", "anchorStreamSwitchContent", "Lcom/bytedance/android/livesdk/message/linker/i;", "getApplyStrongReminderContent", "()Lcom/bytedance/android/livesdk/message/linker/i;", "applyStrongReminderContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "getAudienceWaitingListChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "audienceWaitingListChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "getAvatarAuditContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "avatarAuditContent", "Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "getEnter", "()Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "enter", "getExtraStr", "extraStr", "", "getFromChannelFlex", "()I", "fromChannelFlex", "Lcom/bytedance/android/live/base/model/data/j;", "getGuestInviteContent", "()Lcom/bytedance/android/live/base/model/data/j;", "guestInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "getLeave", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "leave", "Lcom/bytedance/android/live/base/model/data/g;", "getLinkRoomFightCancelInviteContent", "()Lcom/bytedance/android/live/base/model/data/g;", "setLinkRoomFightCancelInviteContent", "(Lcom/bytedance/android/live/base/model/data/g;)V", "linkRoomFightCancelInviteContent", "Lcom/bytedance/android/live/base/model/data/h;", "getLinkRoomFightInviteContent", "()Lcom/bytedance/android/live/base/model/data/h;", "setLinkRoomFightInviteContent", "(Lcom/bytedance/android/live/base/model/data/h;)V", "linkRoomFightInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "getLinkRoomFightReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "setLinkRoomFightReplyContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;)V", "linkRoomFightReplyContent", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "linkerBaseInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "getLinkerBattleConnectContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "linkerBattleConnectContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "getLinkerChangeMediaInfoContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "linkerChangeMediaInfoContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "getLinkerClientUIInfoChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "linkerClientUIInfoChangeContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "getLinkerConfirmUnsilenceContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "linkerConfirmUnsilenceContent", "getLinkerCrossRoomUpdateContentExt", "setLinkerCrossRoomUpdateContentExt", "(Lcom/bytedance/android/live/base/model/data/i;)V", "linkerCrossRoomUpdateContentExt", "Lcom/bytedance/android/livesdk/message/linker/j;", "getLinkerDegradeAlertContent", "()Lcom/bytedance/android/livesdk/message/linker/j;", "linkerDegradeAlertContent", "Lcom/bytedance/android/livesdk/message/linker/f;", "getLinkerEnlargeGuestApplyContent", "()Lcom/bytedance/android/livesdk/message/linker/f;", "linkerEnlargeGuestApplyContent", "Lcom/bytedance/android/livesdk/message/linker/k;", "getLinkerEnlargeGuestInviteContent", "()Lcom/bytedance/android/livesdk/message/linker/k;", "linkerEnlargeGuestInviteContent", "Lcom/bytedance/android/livesdk/message/linker/g;", "getLinkerEnlargeGuestReplyContent", "()Lcom/bytedance/android/livesdk/message/linker/g;", "linkerEnlargeGuestReplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "getLinkerEnlargeUpdateContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "linkerEnlargeUpdateContent", "getLinkerId", "linkerId", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "getLinkerInitChatRoomContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "linkerInitChatRoomContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContent;", "getLinkerInvitePrepareContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContent;", "linkerInvitePrepareContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "getLinkerLiveCoreBizTagChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "setLinkerLiveCoreBizTagChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;)V", "linkerLiveCoreBizTagChangeContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "getLinkerPrepareInviteContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "linkerPrepareInviteContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "getLinkerPrepareReplyContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "linkerPrepareReplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "getLinkerRemoveWaitingUserContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "linkerRemoveWaitingUserContent", "Lcom/bytedance/android/livesdk/link/model/l6;", "getLinkerResumeAudienceContent", "()Lcom/bytedance/android/livesdk/link/model/l6;", "linkerResumeAudienceContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUILayoutChangeContent;", "getLinkerUILayoutChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUILayoutChangeContent;", "linkerUILayoutChangeContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "getLockPositionContent", "()Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "lockPositionContent", "Lcom/bytedance/android/livesdk/message/linker/d;", "getMChangePlayModeContent", "()Lcom/bytedance/android/livesdk/message/linker/d;", "mChangePlayModeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContent;", "getMFollowStrongGuideContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContent;", "mFollowStrongGuideContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "getMKickOut", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "mKickOut", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "getMLinkedListChange", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "mLinkedListChange", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "getMLinkerSysKickOutContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "mLinkerSysKickOutContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLowBalanceForPaidLinkmicContent;", "getMLowBalanceForPaidLinkContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLowBalanceForPaidLinkmicContent;", "mLowBalanceForPaidLinkContent", "getMType", "mType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "getMUpdateUser", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "mUpdateUser", "getMessageId3", "messageId3", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "publicAreaCommon", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "getRtcActionContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "rtcActionContent", "getScene", "scene", "getTimestampFlex", "timestampFlex", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType2", "type2", "Lcom/bytedance/android/livesdk/link/model/ILinkerUpdateLinkTypeApplyContent;", "getUpdateLinkTypeApplyContent", "()Lcom/bytedance/android/livesdk/link/model/ILinkerUpdateLinkTypeApplyContent;", "updateLinkTypeApplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "getUpdateLinkTypeForceOpenCameraContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "updateLinkTypeForceOpenCameraContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent;", "getUpdateLinkTypeReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent;", "updateLinkTypeReplyContent", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/h1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.h1, i6> implements i6, com.bytedance.android.livesdk.link.model.bridge.h1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.h1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public u5 getAnchorStreamSwitchContent() {
        return this.$$delegate_0.getAnchorStreamSwitchContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.i getApplyStrongReminderContent() {
        return this.$$delegate_0.getApplyStrongReminderContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerAudienceWaitingListChangeContent getAudienceWaitingListChangeContent() {
        return this.$$delegate_0.getAudienceWaitingListChangeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerAvatarAuditContent getAvatarAuditContent() {
        return this.$$delegate_0.getAvatarAuditContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return (com.bytedance.android.live.base.model.message.m0) get(1, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.link.model.bridge.f1 getEnter() {
        return this.$$delegate_0.getEnter();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public String getExtraStr() {
        return this.$$delegate_0.getExtraStr();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public int getFromChannelFlex() {
        return this.$$delegate_0.getFromChannelFlex();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.j getGuestInviteContent() {
        return this.$$delegate_0.getGuestInviteContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public e6 getInvite() {
        return (e6) get(5, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLeaveContentBridge getLeave() {
        return this.$$delegate_0.getLeave();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.g getLinkRoomFightCancelInviteContent() {
        return this.$$delegate_0.getLinkRoomFightCancelInviteContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.h getLinkRoomFightInviteContent() {
        return this.$$delegate_0.getLinkRoomFightInviteContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkRoomFightReplyContent getLinkRoomFightReplyContent() {
        return this.$$delegate_0.getLinkRoomFightReplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo() {
        return this.$$delegate_0.getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerBattleConnectContent getLinkerBattleConnectContent() {
        return this.$$delegate_0.getLinkerBattleConnectContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerChangeMediaInfoContent getLinkerChangeMediaInfoContent() {
        return this.$$delegate_0.getLinkerChangeMediaInfoContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerClientUIInfoChangeContent getLinkerClientUIInfoChangeContent() {
        return this.$$delegate_0.getLinkerClientUIInfoChangeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerConfirmUnsilenceContent getLinkerConfirmUnsilenceContent() {
        return this.$$delegate_0.getLinkerConfirmUnsilenceContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContentExt() {
        return this.$$delegate_0.getLinkerCrossRoomUpdateContentExt();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.j getLinkerDegradeAlertContent() {
        return this.$$delegate_0.getLinkerDegradeAlertContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.f getLinkerEnlargeGuestApplyContent() {
        return this.$$delegate_0.getLinkerEnlargeGuestApplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.k getLinkerEnlargeGuestInviteContent() {
        return this.$$delegate_0.getLinkerEnlargeGuestInviteContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.g getLinkerEnlargeGuestReplyContent() {
        return this.$$delegate_0.getLinkerEnlargeGuestReplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerEnlargeUpdateContent getLinkerEnlargeUpdateContent() {
        return this.$$delegate_0.getLinkerEnlargeUpdateContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getLinkerId() {
        return this.$$delegate_0.getLinkerId();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerInitChatRoomContent getLinkerInitChatRoomContent() {
        return this.$$delegate_0.getLinkerInitChatRoomContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerInvitePrepareContent getLinkerInvitePrepareContent() {
        return this.$$delegate_0.getLinkerInvitePrepareContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLiveCoreBizTagChangeContent getLinkerLiveCoreBizTagChangeContent() {
        return this.$$delegate_0.getLinkerLiveCoreBizTagChangeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerPrepareInviteContent getLinkerPrepareInviteContent() {
        return this.$$delegate_0.getLinkerPrepareInviteContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerPrepareReplyContent getLinkerPrepareReplyContent() {
        return this.$$delegate_0.getLinkerPrepareReplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerRemoveWaitingUserContent getLinkerRemoveWaitingUserContent() {
        return this.$$delegate_0.getLinkerRemoveWaitingUserContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public l6 getLinkerResumeAudienceContent() {
        return this.$$delegate_0.getLinkerResumeAudienceContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUILayoutChangeContent getLinkerUILayoutChangeContent() {
        return this.$$delegate_0.getLinkerUILayoutChangeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerLockPositionContent getLockPositionContent() {
        return this.$$delegate_0.getLockPositionContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.d getMChangePlayModeContent() {
        return this.$$delegate_0.getMChangePlayModeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerFollowStrongGuideContent getMFollowStrongGuideContent() {
        return this.$$delegate_0.getMFollowStrongGuideContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent getMKickOut() {
        return this.$$delegate_0.getMKickOut();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLinkedListChangeContent getMLinkedListChange() {
        return this.$$delegate_0.getMLinkedListChange();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerSysKickOutContent getMLinkerSysKickOutContent() {
        return this.$$delegate_0.getMLinkerSysKickOutContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLowBalanceForPaidLinkmicContent getMLowBalanceForPaidLinkContent() {
        return this.$$delegate_0.getMLowBalanceForPaidLinkContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public int getMType() {
        return this.$$delegate_0.getMType();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateUserContent getMUpdateUser() {
        return this.$$delegate_0.getMUpdateUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getMessageId3() {
        return this.$$delegate_0.getMessageId3();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public IPublicAreaCommon getOrInitPublicAreaCommon() {
        return this.$$delegate_0.getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public IPublicAreaCommon getPublicAreaCommon() {
        return this.$$delegate_0.getPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getReceiveNtpTimeFlex(long r2) {
        return this.$$delegate_0.getReceiveNtpTimeFlex(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public k6 getReply() {
        return (k6) get(6, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerRTCActionContent getRtcActionContent() {
        return this.$$delegate_0.getRtcActionContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getScene() {
        return this.$$delegate_0.getScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getTimestampFlex() {
        return this.$$delegate_0.getTimestampFlex();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public long getType2() {
        return this.$$delegate_0.getType2();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent() {
        return this.$$delegate_0.getUpdateLinkTypeApplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateLinkTypeForceOpenCameraContent getUpdateLinkTypeForceOpenCameraContent() {
        return this.$$delegate_0.getUpdateLinkTypeForceOpenCameraContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent() {
        return this.$$delegate_0.getUpdateLinkTypeReplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public IBaseUser getUserInMessage() {
        return this.$$delegate_0.getUserInMessage();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightCancelInviteContent(com.bytedance.android.live.base.model.data.g r2) {
        this.$$delegate_0.setLinkRoomFightCancelInviteContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightInviteContent(com.bytedance.android.live.base.model.data.h r2) {
        this.$$delegate_0.setLinkRoomFightInviteContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightReplyContent(ILinkRoomFightReplyContent r2) {
        this.$$delegate_0.setLinkRoomFightReplyContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkerCrossRoomUpdateContentExt(com.bytedance.android.live.base.model.data.i r2) {
        this.$$delegate_0.setLinkerCrossRoomUpdateContentExt(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6, com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkerLiveCoreBizTagChangeContent(ILinkerLiveCoreBizTagChangeContent r2) {
        this.$$delegate_0.setLinkerLiveCoreBizTagChangeContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public IAnchorUpdateLayoutContent getAnchorUpdateLayoutContent() {
        return (IAnchorUpdateLayoutContent) get(50, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public x getAnchorUpdateLinkMicConfigContent() {
        return (x) get(49, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public x5 getCancel() {
        return (x5) get(11, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public ILinkerCloseContent getClose() {
        return (ILinkerCloseContent) get(8, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public c4 getCrossRoomRTCInfoContent() {
        return (c4) get(48, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public h6 getLinkedListChange() {
        return (h6) get(13, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public w5 getLinkerBanContent() {
        return (w5) get(16, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public y5 getLinkerChangeMultiPkTeamInfoContent() {
        return (y5) get(41, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContent() {
        return (com.bytedance.android.live.base.model.data.i) get(40, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public String getLynxData() {
        return (String) get(com.bytedance.android.livesdk.link.model.bridge.z0.TYPE_BATTLE_REJECT, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public n6 getSwitchChannelCancelContent() {
        return (n6) get(62, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public o6 getSwitchChannelInviteContent() {
        return (o6) get(60, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public p6 getSwitchChannelReplyContent() {
        return (p6) get(61, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public q6 getSwitchSceneContent() {
        return (q6) get(31, i6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public long getVersion() {
        return ((Number) get(com.bytedance.android.livesdk.link.model.bridge.z0.TYPE_BATTLE_INVITE, i6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public r6 getWaitingListChange() {
        return (r6) get(15, i6.class);
    }

    public ILinkerMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.i6
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r4) {
        set(1, "common", i6.class, r4);
    }
}
