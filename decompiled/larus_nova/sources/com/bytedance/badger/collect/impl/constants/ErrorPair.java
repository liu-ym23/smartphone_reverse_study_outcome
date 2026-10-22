package com.bytedance.badger.collect.impl.constants;

import android.util.Pair;

/* JADX INFO: loaded from: classes47.dex */
public class ErrorPair {
    public static final Pair<Integer, String> CLOSE_CARRIER_UAID = null;
    public static final Pair<Integer, String> ERROR_CARRIER_NOT_FOUND = null;
    public static final Pair<Integer, String> ERROR_DEFAULT = null;
    public static final Pair<Integer, String> ERROR_NETWORK_REQUEST = null;
    public static final Pair<Integer, String> ERROR_NETWORK_STATUS = null;
    public static final Pair<Integer, String> ERROR_NETWORK_UNAVAILABLE = null;
    public static final Pair<Integer, String> ERROR_NET_NOT_IMPL = null;
    public static final Pair<Integer, String> ERROR_WORKER_EXECUTE_FAILED = null;
    public static final Pair<Integer, String> NOT_BEEN_REACHED_POLLING_TIME = null;
    public static final Pair<Integer, String> RETRY_COUNT_UPPER_LIMIT = null;

    public ErrorPair() {
    }

    static {
        ERROR_DEFAULT = new Pair(-1000, "");
        ERROR_NETWORK_REQUEST = new Pair(-1001, "网络请求失败");
        NOT_BEEN_REACHED_POLLING_TIME = new Pair(-1002, "未达到轮询间隔");
        RETRY_COUNT_UPPER_LIMIT = new Pair(-1003, "重试次数上限");
        ERROR_WORKER_EXECUTE_FAILED = new Pair(-1004, "worker执行失败");
        ERROR_NETWORK_STATUS = new Pair(-1005, "运营商网络状态错误");
        ERROR_CARRIER_NOT_FOUND = new Pair(-1006, "无SIM卡，未找到运营商");
        ERROR_NETWORK_UNAVAILABLE = new Pair(-1007, "切换蜂窝数据失败，找不到Network");
        CLOSE_CARRIER_UAID = new Pair(-1008, " 运营商能力被强制关闭");
        ERROR_NET_NOT_IMPL = new Pair(-1009, "网络接口未实现");
    }
}
