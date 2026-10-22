package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import dagger.MapKey;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes35.dex */
@MapKey
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chatwindow/launcher/transform/TransformKey;", "", "value", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface TransformKey {
    ILaunchDataInput.LaunchDataType value();
}
