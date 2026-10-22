package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003R+\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR%\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\b\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR1\u0010\u000f\u001a\u001f\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/ListListener;", ExifInterface.GPS_DIRECTION_TRUE, "RECEIVER", "", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function2;", "", "", "Lkotlin/ExtensionFunctionType;", "getOnError", "()Lkotlin/jvm/functions/Function2;", "onLoading", "Lkotlin/Function1;", "getOnLoading", "()Lkotlin/jvm/functions/Function1;", "onSuccess", "", "getOnSuccess", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public interface ListListener<T, RECEIVER> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static <T, RECEIVER> Function2<RECEIVER, Throwable, Unit> getOnError(ListListener<T, RECEIVER> r100) {
            return ListListener$onError$1.INSTANCE;
        }

        public static <T, RECEIVER> Function1<RECEIVER, Unit> getOnLoading(ListListener<T, RECEIVER> r100) {
            return ListListener$onLoading$1.INSTANCE;
        }

        public static <T, RECEIVER> Function2<RECEIVER, List<? extends T>, Unit> getOnSuccess(ListListener<T, RECEIVER> r100) {
            return ListListener$onSuccess$1.INSTANCE;
        }
    }

    Function2<RECEIVER, Throwable, Unit> getOnError();

    Function1<RECEIVER, Unit> getOnLoading();

    Function2<RECEIVER, List<? extends T>, Unit> getOnSuccess();
}
