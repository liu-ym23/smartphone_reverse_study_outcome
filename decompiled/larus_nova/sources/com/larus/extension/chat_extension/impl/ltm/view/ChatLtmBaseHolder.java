package com.larus.extension.chat_extension.impl.ltm.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.extension.chat_extension.impl.ltm.r;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindData", "", "data", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatLtmBaseHolder extends RecyclerView.ViewHolder {

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder$Companion$ChatItemViewType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "TITLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ChatItemViewType extends Enum<ChatItemViewType> {
            public static final ChatItemViewType NORMAL = null;
            public static final ChatItemViewType TITLE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ChatItemViewType[] f342879a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f342880b = null;
            private final int value;

            public static EnumEntries<ChatItemViewType> getEntries() {
                return f342880b;
            }

            static {
                ChatItemViewType r100 = new ChatItemViewType(EffectConstants.NORMAL, 0, 0);
                NORMAL = r100;
                ChatItemViewType r101 = new ChatItemViewType("TITLE", 1, 1);
                TITLE = r101;
                ChatItemViewType[] r102 = {r100, r101};
                f342879a = r102;
                f342880b = EnumEntriesKt.enumEntries(r102);
            }

            public static ChatItemViewType[] values() {
                return (ChatItemViewType[]) f342879a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChatItemViewType valueOf(String r100) {
                return (ChatItemViewType) a.a(ChatItemViewType.class, r100);
            }

            public ChatItemViewType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }
    }

    static {
    }

    public abstract void T3(r r100);

    public ChatLtmBaseHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
