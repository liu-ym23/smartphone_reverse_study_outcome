package com.ss.android.lark.biz.im.api.chat.setting;

import android.widget.CompoundButton;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0004R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/ChatSettingSwitchPiece;", "Lcom/ss/android/lark/biz/im/api/chat/setting/SettingSwitchPiece;", "<init>", "()V", "chatChangedObserver", "Lcom/ss/android/lark/piece/data/DataObserver;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "registerShareData", "", "getOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCheckedChanged", "isChecked", "", "onChatChanged", "chat", "getCheckedState", "isContentViewVisible", "isContentViewEnable", "getChat", "getPageType", "", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatSettingSwitchPiece extends SettingSwitchPiece {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f410065i;

    public static final class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatSettingSwitchPiece f410066a;

        public a(ChatSettingSwitchPiece r100) {
            this.f410066a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            this.f410066a.f();
        }
    }

    public static final class b extends com.ss.android.lark.piece.data.a<Chat> {
        public b() {
            super(0);
        }
    }

    public abstract void f();

    @Override // com.ss.android.lark.biz.im.api.chat.setting.SettingBasePiece
    public final void c() {
        a(Chat.class, this.f410065i);
    }

    @Override // com.ss.android.lark.biz.im.api.chat.setting.SettingSwitchPiece
    public final CompoundButton.OnCheckedChangeListener e() {
        return new a(this);
    }

    public ChatSettingSwitchPiece() {
        this.f410065i = new b();
    }
}
