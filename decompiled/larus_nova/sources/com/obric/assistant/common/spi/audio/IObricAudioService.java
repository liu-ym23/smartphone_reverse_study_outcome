package com.obric.assistant.common.spi.audio;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Deprecated(message = "语音重构预收音等逻辑后删除")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "", "shouldNotPlayTts", "", "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "isOAutoCallUserMessageMustPlayTts", "getCurrentAudioFocusOwner", "", "isSystemNotification", "isCurrentFocusOwnerPhoneCall", "shouldBypassFocusFail", "scene", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAudioService {
    boolean b(String r100);

    String c();

    boolean d();

    boolean e();
}
