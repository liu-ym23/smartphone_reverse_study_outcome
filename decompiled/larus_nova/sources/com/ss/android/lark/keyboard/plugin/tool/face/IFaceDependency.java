package com.ss.android.lark.keyboard.plugin.tool.face;

import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.z2;

/* JADX INFO: loaded from: classes36.dex */
public interface IFaceDependency {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/IFaceDependency$EmojiScene;", "", "value", "Lcom/ss/android/lark/statistics/extensions/IParam;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/statistics/extensions/IParam;)V", "getValue", "()Lcom/ss/android/lark/statistics/extensions/IParam;", "setValue", "(Lcom/ss/android/lark/statistics/extensions/IParam;)V", "IM", "MOMENTS", AlarmSessionType.TODO, "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EmojiScene extends Enum<EmojiScene> {
        public static final EmojiScene IM = null;
        public static final EmojiScene MOMENTS = null;
        public static final EmojiScene TODO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EmojiScene[] f429640a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429641b = null;
        private s5c.d value;

        public static EnumEntries<EmojiScene> getEntries() {
            return f429641b;
        }

        static {
            EmojiScene r100 = new EmojiScene("IM", 0, z2.f570430c);
            IM = r100;
            EmojiScene r101 = new EmojiScene("MOMENTS", 1, z2.f570432e);
            MOMENTS = r101;
            EmojiScene r102 = new EmojiScene(AlarmSessionType.TODO, 2, z2.f570433f);
            TODO = r102;
            EmojiScene[] r103 = {r100, r101, r102};
            f429640a = r103;
            f429641b = EnumEntriesKt.enumEntries(r103);
        }

        public static EmojiScene[] values() {
            return (EmojiScene[]) f429640a.clone();
        }

        public final s5c.d getValue() {
            return this.value;
        }

        public static EmojiScene valueOf(String r100) {
            return (EmojiScene) r27.a.a(EmojiScene.class, r100);
        }

        public final void setValue(s5c.d r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.value = r100;
        }

        public EmojiScene(String r100, int r101, s5c.a r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
