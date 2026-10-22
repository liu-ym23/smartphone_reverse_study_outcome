package com.obric.assistant.interaction.api.window.animation;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "", "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWindowAnimationProvider {
    List<IWindowAnimator> getWindowAnimators(boolean r100, WindowAnimationType r101);
}
